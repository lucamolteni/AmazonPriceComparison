package it.comparison;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RealAmazonTest {

    @Test
    public void chiedePaginaHtml(){
        FakeFetcher fetcher = new FakeFetcher();
        FakeParser parser = new FakeParser();
        Amazon amazon = new RealAmazon(fetcher, parser, "http://amazon.fr");

        fetcher.setResponse("<html>myproduct</html>");

        amazon.findPrice("1235452352");

        fetcher.fetchWasCalled("http://amazon.fr/1235452352");
        parser.parseWasCalled("<html>myproduct</html>");

    }

    private class FakeFetcher implements Fetcher {
        private String response;
        private String parameter;

        public void setResponse(String response) {
            this.response = response;
        }

        public void fetchWasCalled(String expected) {
            assertEquals("Fetcher.fetch was called with parameter", expected, parameter);
        }

        @Override
        public String fetch(String url) {
            parameter = url;
            return response;
        }
    }

    private class FakeParser implements Parser {

        private String parameter;

        public void parseWasCalled(String expected) {
            assertEquals("Parser.parse was called with parameter", expected, parameter);
        }

        @Override
        public String parse(String html) {
            parameter = html;
            return null;
        }
    }
}