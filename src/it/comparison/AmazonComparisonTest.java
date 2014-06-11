package it.comparison;

import org.junit.Before;
import org.junit.Test;

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
        amazonit = new FakeAmazon();
        amazonfrance = new FakeAmazon();
    }

    @Test
    public void comparatoreDeveChiamareSiti() {
        comparison.addSite(amazonit);
        comparison.addSite(amazonfrance);

        comparison.findPrices("7834920174389012");

        assertTrue(amazonit.wasCalled("7834920174389012"));
        assertTrue(amazonfrance.wasCalled("7834920174389012"));
    }

    @Test
    public void comparatoreDeveRestituirePrezzi() {
        comparison.addSite(amazonit);
        comparison.addSite(amazonfrance);

        PriceResults prices = comparison.findPrices("7834920174389012");

        assertTrue(prices.getPrice(amazonit).equals("6,99"));
        assertTrue(prices.getPrice(amazonfrance).equals("6,99"));

    }

    @Test
    public void vediTabella(){

        comparison.findPrices("dashjklhdasjkl");

        assertTrue(fakeDisplay.wasCalled());
    }

    public static class FakeAmazon implements Amazon {

        private String isbnCalled;

        public boolean wasCalled(String isbn) {
            return isbn.equals(isbnCalled);
        }

        @Override
        public String findPrice(String isbn) {
            isbnCalled = isbn;
            return "6,99";
        }

        @Override
        public void setSite(String s) {

        }

        @Override
        public String getSite() {
            return "siteUrl";
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
