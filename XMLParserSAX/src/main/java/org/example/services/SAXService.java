package org.example.services;

import org.example.dao.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXService extends DefaultHandler{
    private Root root;
    private List<Bottom> bottoms;
    private List<Yard> yards;
    private List<Come> comes = new ArrayList<>();
    private List<Evidence> evidences = new ArrayList<>();
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
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
            String value = "";
            for(int i = 0; i < attributes.getLength(); i++)
            {
                String attr = attributes.getLocalName(i);
                if(attr.equals("attr"))
                {
                    value = attributes.getValue(i);
                }
            }
            Yard yard = new Yard(value);
            this.yards.add(yard);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
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

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Attr = "+new String(ch));
        if(ch[0] == 't')
        {
            int lastIndexOfCome = this.comes.size() - 1;
            Come come = this.comes.get(lastIndexOfCome);
            come.setValue(new String(ch));
        }
        else if(ch[0] == 'f')
        {
            int lastIndexOfEvidence = this.evidences.size() - 1;
            Evidence evidence = this.evidences.get(lastIndexOfEvidence);
            evidence.setValue(new String(ch));
        }
        else if(ch[0] == 'o')
        {
            int lastIndexOfYard = this.yards.size() - 1;
            Yard yard = this.yards.get(lastIndexOfYard);
            yard.setValue(new String(ch));
        }
    }

}
