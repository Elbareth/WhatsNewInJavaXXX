package org.example.transform;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XSLTTransformer {
    public void transform(String sourceFilename, String targetFilename) throws TransformerException, IOException {
        //We will transform generated file into HTML file
        //We open file with our transformer pattern
        File styleSheet = new File("transform.xsl");
        //We create stream from it
        StreamSource streamSource = new StreamSource(styleSheet);
        //We create our transformer object
        Transformer transformer = TransformerFactory.newInstance().newTransformer(streamSource);
        //We transform our data
        transformer.transform(new SAXSource(new InputSource(new FileInputStream(sourceFilename))), new StreamResult(targetFilename));
    }
}
