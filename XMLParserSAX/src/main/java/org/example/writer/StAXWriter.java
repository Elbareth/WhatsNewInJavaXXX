package org.example.writer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StAXWriter {

    public void writer(String filename) throws IOException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(filename));

        /* We will create similar xml but repeated 10 times
        <root>
            <who main="moment">-993591092</who>
            <remove swing="leaf">led</remove>
            <rocky>-1126696417.481776</rocky>
        </root>
         */

        //We create new document
        writer.writeStartDocument();
        //We create root element
        writer.writeStartElement("root");
        for(int i = 0; i < 10; i++)
        {
            //We create who element
            writer.writeStartElement("who");
            writer.writeAttribute("main", "moment"+i);
            writer.writeCharacters(((Double) (Math.random() * 10000)).toString());
            writer.writeEndElement();

            //We create remove element
            writer.writeStartElement("remove");
            writer.writeAttribute("swing", "leaf"+i);
            writer.writeCharacters("led"+(i*i));
            writer.writeEndElement();

            //We create rocky element
            writer.writeStartElement("rocky");
            writer.writeCharacters(((Double) (Math.random() * (-10000))).toString());
            writer.writeEndElement();
        }
        writer.writeEndElement();
        writer.writeEndDocument();
    }
}
