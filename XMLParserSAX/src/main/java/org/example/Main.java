package org.example;

import org.example.reader.SAXReader;
import org.example.reader.StAXReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            reader.parse("file.xml");
            StAXReader readerStAX = new StAXReader();
            readerStAX.parse("file.xml");
        } catch (ParserConfigurationException | SAXException | IOException | XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }
}