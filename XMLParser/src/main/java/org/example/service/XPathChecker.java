package org.example.service;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class XPathChecker {
    private XPath path;
    private Document document;
    public XPathChecker(String filename) throws ParserConfigurationException, IOException, SAXException {
        XPathFactory factory = XPathFactory.newInstance();
        this.path = factory.newXPath();
        DTDParser parser = new DTDParser();
        this.document = parser.parseDocument(filename);
    }
    public Integer calculateCountOfDeers() throws XPathExpressionException {
        return ((Number) this.path.evaluate("count(/root/deer)", this.document, XPathConstants.NUMBER)).intValue();
    }
    public Node getFirstGas() throws XPathExpressionException {
        return (Node) this.path.evaluate("/root/deer/highway/gas[1]", this.document, XPathConstants.NODE);
    }

    public String getFirstGasText() throws XPathExpressionException {
        return (String) this.path.evaluate("/root/deer/highway/gas[1]/text()", this.document, XPathConstants.STRING);
    }
    public String getValueOfRecent() throws XPathExpressionException {
        return (String) this.path.evaluate("/root/deer/recent/@place", this.document, XPathConstants.STRING);
    }
}
