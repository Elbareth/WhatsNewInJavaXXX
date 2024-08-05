package org.example.reader;

import org.example.dao.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXReader {
    private Root root;
    private List<Bottom> bottoms;
    private List<Yard> yards;
    private List<Come> comes = new ArrayList<>();
    private List<Evidence> evidences = new ArrayList<>();
    public void parse(String filename) throws XMLStreamException, IOException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        InputStream inputStream = new FileInputStream(filename);
        XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
        while (reader.hasNext())
        {
            int event = reader.next();
            if(event == XMLStreamConstants.START_ELEMENT)
            {
                String qName = reader.getLocalName();
                System.out.println("Start = "+qName);
                if(qName.equals("root"))
                {
                    this.root = new Root();
                    this.bottoms = this.root.getBottoms();
                    this.yards = this.root.getYards();
                }
                else if(qName.equals("bottom"))
                {
                    Bottom bottom = new Bottom();
                    this.bottoms.add(bottom);
                }
                else if (qName.equals("come"))
                {
                    Come come = new Come();
                    this.comes.add(come);
                }
                else if (qName.equals("evidence"))
                {
                    Evidence evidence = new Evidence();
                    this.evidences.add(evidence);
                }
                else if (qName.equals("yard"))
                {

                    String value = reader.getAttributeValue(null, "attr");
                    Yard yard = new Yard(value);
                    this.yards.add(yard);
                }
            }
            else if(event == XMLStreamConstants.END_ELEMENT)
            {
                String qName = reader.getLocalName();
                System.out.println("End = "+qName);
                if(qName.equals("root"))
                {
                    System.out.println(this.bottoms.size());
                    for(int i = 0; i < this.bottoms.size(); i++)
                    {
                        this.root.addBottoms(this.bottoms.get(i));
                        break;
                    }
                    for (int i = 0; i < yards.size(); i++)
                    {
                        this.root.addYards(yards.get(i));
                        break;
                    }
                    System.out.println("Ready XML = "+root);
                }
                else if(qName.equals("bottom"))
                {
                    int lastIndexOfCome = this.comes.size() - 1;
                    int lastIndexOfEvidence = this.evidences.size() - 1;
                    int lastIndexOfBottom = this.bottoms.size() - 1;
                    Bottom bottom = bottoms.get(lastIndexOfBottom);
                    bottom.setCome(this.comes.get(lastIndexOfCome));
                    bottom.setEvidence(this.evidences.get(lastIndexOfEvidence));
                }
            }
            else if (event == XMLStreamConstants.ATTRIBUTE)
            {
                String ch = reader.getElementText();
                System.out.println("Attr = "+ch);
                if(ch.startsWith("t"))
                {
                    int lastIndexOfCome = this.comes.size() - 1;
                    Come come = this.comes.get(lastIndexOfCome);
                    come.setValue(ch);
                }
                else if(ch.startsWith("f"))
                {
                    int lastIndexOfEvidence = this.evidences.size() - 1;
                    Evidence evidence = this.evidences.get(lastIndexOfEvidence);
                    evidence.setValue(ch);
                }
                else if(ch.startsWith("o"))
                {
                    int lastIndexOfYard = this.yards.size() - 1;
                    Yard yard = this.yards.get(lastIndexOfYard);
                    yard.setValue(ch);
                }
            }
        }
    }
}
