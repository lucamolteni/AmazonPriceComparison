package it.comparison;

import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class RealParserTest {

    @Test
    public void trovaPrezzoInPagina() throws IOException, XPathExpressionException, ParserConfigurationException {
        RealParser parser = new RealParser();

        String amazonHtml = new String(Files.readAllBytes(FileSystems.getDefault().getPath("res.html")));

        String price = parser.parse(amazonHtml);

        assertEquals("EUR\n" +
                "                                    8,50", price);
    }


}