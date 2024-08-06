package org.example.writer;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {
    public void writeToFile(Document document, String filename) throws IOException {
        //We convert our DOM to serializable stream
        DOMImplementation implementation = document.getImplementation();
        DOMImplementationLS ls = (DOMImplementationLS) implementation.getFeature("LS", "3.0");
        LSSerializer serializer = ls.createLSSerializer();

        //We want file to be pretty ^^
        serializer.getDomConfig().setParameter("format-pretty-print", true);

        //We write information to file
        LSOutput output = ls.createLSOutput();
        output.setEncoding("UTF-8");
        output.setByteStream(Files.newOutputStream(Path.of(filename)));
        serializer.write(document, output);
    }
}
