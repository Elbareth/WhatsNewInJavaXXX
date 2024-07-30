package org.example;

import org.example.entity.Root;
import org.example.service.DTDParser;
import org.example.service.XPathChecker;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            Root root = new DTDParser().parseXML("new.xml");
            System.out.println("How my XML looks like");
            System.out.println(root);
            XPathChecker checker = new XPathChecker("new.xml");
            System.out.println("The number of deers = " + checker.calculateCountOfDeers());
            System.out.println("First gas = " + checker.getFirstGas());
            System.out.println("First gas value = " + checker.getFirstGasText());
            System.out.println("Attribute of recent = " +checker.getValueOfRecent());
        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}