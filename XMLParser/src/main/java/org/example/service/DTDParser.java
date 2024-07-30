package org.example.service;

import org.example.entity.*;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DTDParser {
    public Document parseDocument(String filename) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //We want to validate our xml file
        documentBuilderFactory.setValidating(true);
        //We want to ignore whitespaces
        documentBuilderFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        //We have to handle possible errors
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("WARN: " + exception);
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("ERR: " + exception);
                System.exit(0);
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("FATAL: " + exception);
                System.exit(0);
            }
        });
        return builder.parse(filename);
    }
    public Root parseXML(String filename) throws ParserConfigurationException, IOException, SAXException
    {
        Document doc = parseDocument(filename);
        return parseRootChild(doc.getDocumentElement());
    }
    private Root parseRootChild(Element element)
    {
        Root root = new Root();
        NodeList nodeList = element.getChildNodes();
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            var child = nodeList.item(i);
            String tagName = ((Element) child).getTagName();
            if(tagName.equals("deer"))
            {
                Deer deer = parseDeerChild((Element) child);
                root.addDeers(deer);
            }
            else if(tagName.equals("whatever"))
            {
                Node currentChild = child.getFirstChild();
                String childData = ((CharacterData) currentChild).getData();
                Whatever whatever = new Whatever(((Element) child).getAttribute("life"), childData);
                root.addWhatevers(whatever);
            }
            else if(tagName.equals("fine"))
            {

                Node currentChild = child.getFirstChild();
                String childData = ((CharacterData) currentChild).getData();
                Fine fine = new Fine(childData);
                root.addFines(fine);
            }
        }
        return root;
    }
    private Deer parseDeerChild(Element element)
    {
        Deer deer = new Deer();
        NodeList nodeList = element.getChildNodes();
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            var child = nodeList.item(i);
            String tagName = ((Element) child).getTagName();
            if(tagName.equals("recent"))
            {
                Node currentChild = child.getFirstChild();
                String childData = ((CharacterData) currentChild).getData();
                Recent recent = new Recent(((Element) child).getAttribute("place"), Double.valueOf(childData));
                deer.addRecents(recent);
            }
            else if(tagName.equals("highway"))
            {
                Highway highway = parseHighwayChild((Element) child);
                deer.addHighways(highway);
            }
            else if(tagName.equals("pipe"))
            {
                Node currentChild = child.getFirstChild();
                String childData = ((CharacterData) currentChild).getData();
                Pipe pipe = new Pipe(childData);
                deer.addPipes(pipe);
            }
        }
        return deer;
    }
    private Highway parseHighwayChild(Element element)
    {

        Highway highway = new Highway();
        NodeList nodeList = element.getChildNodes();
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            var child = nodeList.item(i);
            String tagName = ((Element) child).getTagName();
            if(tagName.equals("gas"))
            {
                Node currentChild = child.getFirstChild();
                String childData = ((CharacterData) currentChild).getData();
                Gas gas = new Gas(childData);
                highway.setGas(gas);
            }
            else if(tagName.equals("low"))
            {
                Node currentChild = child.getFirstChild();
                String childData = ((CharacterData) currentChild).getData();
                Low low = new Low(Long.valueOf(childData));
                highway.setLow(low);
            }
            else if(tagName.equals("zoo"))
            {
                Node currentChild = child.getFirstChild();
                String childData = ((CharacterData) currentChild).getData();
                Zoo zoo = new Zoo(Long.valueOf(childData));
                highway.setZoo(zoo);
            }
        }
        return highway;
    }
}
