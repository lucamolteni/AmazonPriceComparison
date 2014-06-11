package it.comparison;

import java.util.ArrayList;
import java.util.List;

public class PriceResults {

    private List<PriceResult> prices = new ArrayList<>();

    public void addResult(Amazon amazon, String price){
        this.prices.add(new PriceResult(amazon.getSite(), price));
    }

    public String getPrice(final Amazon amazon) {
        return prices.stream()
                .filter(x -> x.getUrl().equals(amazon.getSite()))
                .findFirst().get().getPrice();
    }

    public List<PriceResult> getPrices() {
        return prices;
    }

    public class PriceResult {

        String url;
        String price;

        public PriceResult(String url, String price) {
            this.url = url;
            this.price = price;
        }

        public String getUrl() {
            return url;
        }

        public String getPrice() {
            return price;
        }
    }
}
