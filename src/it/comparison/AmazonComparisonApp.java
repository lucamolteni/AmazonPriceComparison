package it.comparison;

public class AmazonComparisonApp {

    public static void main(String[] args) {
        AmazonComparison comparison = new AmazonComparison(new RealDisplay());

        Fetcher fetcher = new RealFetcher();
        Parser parser = new RealParser();

        Amazon italia = new RealAmazon(fetcher, parser, "http://www.amazon.it/dp");
        Amazon francia = new RealAmazon(fetcher, parser, "http://www.amazon.fr/dp");
        Amazon germania = new RealAmazon(fetcher, parser, "http://www.amazon.de/dp");

        comparison.addSite(italia);
        comparison.addSite(francia);
        comparison.addSite(germania);

        comparison.findPrices(args[0]);

    }
}
