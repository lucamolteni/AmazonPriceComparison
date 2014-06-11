package it.comparison;

public class RealAmazon implements Amazon{
    private Fetcher fetcher;
    private Parser parser;
    private String site;

    public RealAmazon(Fetcher fetcher, Parser parser, String site) {
        this.fetcher = fetcher;
        this.parser = parser;
        this.site = site;
    }

    @Override
    public String findPrice(String isbn) {
        String html = fetcher.fetch(site + "/" + isbn);
        return parser.parse(html);
    }

    @Override
    public String getSite() {
        return site;
    }
}
