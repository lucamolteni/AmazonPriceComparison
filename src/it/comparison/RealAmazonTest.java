package it.comparison;

import org.junit.Assert;
import org.junit.Test;

public class RealAmazonTest {

    @Test
    public void chiedePaginaHtml(){
        FakeFetcher fetcher = new FakeFetcher();
        FakeParser parser = new FakeParser();
        Amazon amazon = new RealAmazon(fetcher, parser, "http://amazon.fr");

        fetcher.setResponse("<html>myproduct</html>");

        amazon.findPrice("1235452352");

        Assert.assertTrue(fetcher.wasCalled("http://amazon.fr/1235452352"));
        Assert.assertTrue(parser.wasCalled("<html>myproduct</html>"));

    }

    private class FakeFetcher implements Fetcher {
        private String response;
        private String parameter;

        public void setResponse(String response) {
            this.response = response;
        }

        public boolean wasCalled(String parameterPassed) {
            return parameterPassed.equals(parameter);
        }

        @Override
        public String fetch(String url) {
            parameter = url;
            return response;
        }
    }

    private class FakeParser implements Parser {

        private String parameter;

        public boolean wasCalled(String s) {
            return s.equals(parameter);
        }

        @Override
        public String parse(String html) {
            parameter = html;
            return null;
        }
    }
}