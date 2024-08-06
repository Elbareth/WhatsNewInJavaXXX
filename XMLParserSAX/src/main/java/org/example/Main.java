package org.example;

import org.example.reader.SAXReader;
import org.example.reader.StAXReader;
import org.example.transform.XSLTTransformer;
import org.example.writer.DOMWriterWithNamespaces;
import org.example.writer.DOMWriterWithoutNamespace;
import org.example.writer.FileWriter;
import org.example.writer.StAXWriter;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            //We read XML from file
            SAXReader reader = new SAXReader();
            reader.parse("file.xml");
            StAXReader readerStAX = new StAXReader();
            readerStAX.parse("file.xml");

            //And we write to file
            FileWriter fileWriter = new FileWriter();
            DOMWriterWithNamespaces withNamespaces = new DOMWriterWithNamespaces();
            Document documentWithNamespace = withNamespaces.write();
            fileWriter.writeToFile(documentWithNamespace, "xmlWithNamespace.xml");

            DOMWriterWithoutNamespace withoutNamespace = new DOMWriterWithoutNamespace();
            Document documentWithoutNamespace = withoutNamespace.write();
            fileWriter.writeToFile(documentWithoutNamespace, "xmlWithoutNamespace.xml");

            //We use StAX to write to file
            StAXWriter stAXWriter = new StAXWriter();
            stAXWriter.writer("StAXFile.xml");

            //We transform the file
            XSLTTransformer transformer = new XSLTTransformer();
            transformer.transform("StAXFile.xml", "index.html");

        } catch (ParserConfigurationException | SAXException | IOException | XMLStreamException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}