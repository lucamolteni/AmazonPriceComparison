package it.comparison;

public class RealDisplayTest {

    public static void main(String[] args) {
        RealDisplay display = new RealDisplay();

        PriceResults result = new PriceResults();

        Amazon a = new AmazonComparisonTest.FakeAmazon();

        result.addResult(a, "6,99");

        display.show(result);
    }
}