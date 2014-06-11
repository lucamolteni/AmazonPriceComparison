package it.comparison;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AmazonComparisonTest {

    private FakeDisplay fakeDisplay;
    private AmazonComparison comparison;
    private FakeAmazon amazonit;
    private FakeAmazon amazonfrance;

    @Before
    public void setUp() throws Exception {
        fakeDisplay = new FakeDisplay();
        comparison = new AmazonComparison(fakeDisplay);
        amazonit = new FakeAmazon("6,99", "amazon.it");
        amazonfrance = new FakeAmazon("7,00", "amazon.fr");
    }

    @Test
    public void comparatoreDeveChiamareSiti() {
        comparison.addSite(amazonit);
        comparison.addSite(amazonfrance);

        comparison.findPrices("7834920174389012");

        amazonit.assertFindPriceWasCalled("7834920174389012");
        amazonfrance.assertFindPriceWasCalled("7834920174389012");
    }

    @Test
    public void comparatoreDeveRestituirePrezzi() {
        comparison.addSite(amazonit);
        comparison.addSite(amazonfrance);

        PriceResults prices = comparison.findPrices("7834920174389012");

        assertEquals("6,99", prices.getPrice(amazonit));
        assertEquals("7,00", prices.getPrice(amazonfrance));
    }

    @Test
    public void vediTabella(){

        comparison.findPrices("dashjklhdasjkl");

        assertTrue(fakeDisplay.wasCalled());
    }

    public static class FakeAmazon implements Amazon {

        private String isbnCalled;

        private String price;
        private String site;

        public FakeAmazon(String price, String url) {
            this.price = price;
            this.site = url;
        }

        @Override
        public String findPrice(String isbn) {
            isbnCalled = isbn;
            return price;
        }

        @Override
        public void setSite(String s) {

        }

        @Override
        public String getSite() {
            return site;
        }

        public void assertFindPriceWasCalled(String s) {
            assertEquals("Amazon.findPrice with wrong ISBN", s, isbnCalled);
        }
    }

    private class FakeDisplay implements Display{
        private boolean wasCalled = false;

        @Override
        public void show(PriceResults results) {
            wasCalled = true;
        }

        public boolean wasCalled(){
            return wasCalled;
        }
    }
}
