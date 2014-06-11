package it.comparison;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class RealParser implements Parser {
    @Override
    public String parse(String html) {
        TagNode tagNode = new HtmlCleaner().clean(html);
        org.w3c.dom.Document doc = null;
        try {
            doc = new DomSerializer(
                    new CleanerProperties()).createDOM(tagNode);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return "";
        }

        XPath xpath = XPathFactory.newInstance().newXPath();
        String str = null;
        try {
            str = (String) xpath.evaluate("//b[@class='priceLarge']\n",
                    doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            return "";
        }


        return str.trim();
    }


}
