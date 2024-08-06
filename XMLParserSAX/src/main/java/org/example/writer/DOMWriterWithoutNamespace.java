package org.example.writer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMWriterWithoutNamespace {
    public Document write() throws ParserConfigurationException {
        /* We try to write this XML file
        <root>
            <bottom>
                <come>theory</come>
                <evidence>faster</evidence>
            </bottom>
            <yard attr = "new" >oldest</yard>
        </root>*/

        //At the beginning we create empty document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        //Then we have to create root element
        Element root = doc.createElement("root");

        //We create bottom element with it's children
        Element bottom = doc.createElement("bottom");
        Element come = doc.createElement("come");
        Text theory = doc.createTextNode("theory");
        come.appendChild(theory);
        bottom.appendChild(come);
        Element evidence = doc.createElement("evidence");
        Text faster = doc.createTextNode("faster");
        evidence.appendChild(faster);
        bottom.appendChild(evidence);
        root.appendChild(bottom);

        //We create yard element
        Element yard = doc.createElement("yard");
        yard.setAttribute("attr", "new");
        Text oldest = doc.createTextNode("oldest");
        yard.appendChild(oldest);
        root.appendChild(yard);
        doc.appendChild(root);

        return doc;
    }
}
