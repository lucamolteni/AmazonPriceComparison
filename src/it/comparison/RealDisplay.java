package it.comparison;

import java.util.Map;

public class RealDisplay implements Display {
    @Override
    public void show(PriceResults results) {

        System.out.println("URL - Price\n");
        for(Map.Entry<String, String> o : results.getPrices().entrySet()) {
            System.out.printf("%s - %s\n", o.getKey(), o.getValue());
        }
    }
}
