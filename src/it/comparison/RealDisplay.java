package it.comparison;

public class RealDisplay implements Display {
    @Override
    public void show(PriceResults results) {

        System.out.println("URL - Price\n");

        results.getPrices().stream()
                .forEach(o -> System.out.printf("%s - %s\n", o.getUrl(), o.getPrice()));

    }
}
