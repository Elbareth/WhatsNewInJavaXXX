package org.example.writer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMWriterWithNamespaces {
    /* We want to create such xml file with prefix
    <root>
        <abc:promised xyz:hurt="exactly">
            <abc:cry xyz:public="halfway">till</abc:cry>
            <abc:please xyz:at="four">read</abc:please>
        </abc:promised>
        <level shine="declared">-1960015859.6524591</level>
    </root>*/

    public Document write() throws ParserConfigurationException {
        //Create document that is namespace aware
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        //Create root element
        Element root = doc.createElement("root");

        //Create promised element
        Element promised = doc.createElementNS("abc", "promised");
        promised.setAttributeNS("xyz", "hurt", "exactly");
        Element cry = doc.createElementNS("abc", "cry");
        cry.setAttributeNS("xyz", "public", "halfway");
        Text till = doc.createTextNode("till");
        cry.appendChild(till);
        promised.appendChild(cry);
        Element please = doc.createElementNS("abc", "please");
        please.setAttributeNS("xyz", "at", "four");
        Text read = doc.createTextNode("read");
        please.appendChild(read);
        promised.appendChild(please);
        root.appendChild(promised);

        //Create level element
        Element level = doc.createElement("level");
        level.setAttribute("shine", "declared");
        Text bigNumber = doc.createTextNode("-1960015859.6524591");
        level.appendChild(bigNumber);
        root.appendChild(level);
        doc.appendChild(root);

        return doc;
    }
}
