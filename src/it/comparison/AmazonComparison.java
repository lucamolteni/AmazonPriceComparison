package it.comparison;

import java.util.ArrayList;
import java.util.List;

public class AmazonComparison {
    private List<Amazon> amazonSites = new ArrayList<Amazon>();
    private Display display;

    public AmazonComparison(Display display) {
        this.display = display;
    }

    public PriceResults findPrices(String isbn) {
        PriceResults priceResults = new PriceResults();
        for (Amazon site : amazonSites) {
            String price = site.findPrice(isbn);
            priceResults.addResult(site, price);
        }
        display.show(priceResults);
        return priceResults;
    }

    public void addSite(Amazon amazon) {
        amazonSites.add(amazon);
    }
}
