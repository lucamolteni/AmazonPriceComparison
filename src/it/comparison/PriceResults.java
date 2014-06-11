package it.comparison;

import java.util.HashMap;
import java.util.Map;

public class PriceResults {

    private Map<String, String> prices = new HashMap<String, String>();

    public void addResult(Amazon amazon, String price){
        this.prices.put(amazon.getSite(), price);
    }

    public String getPrice(Amazon amazon) {
        return prices.get(amazon.getSite());
    }

    public Map<String, String> getPrices() {
        return prices;
    }
}
