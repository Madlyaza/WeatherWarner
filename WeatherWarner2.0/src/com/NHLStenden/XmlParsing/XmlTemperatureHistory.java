package com.NHLStenden.XmlParsing;

import com.NHLStenden.GUI;
import com.sun.tools.jconsole.JConsoleContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.sound.midi.SysexMessage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class XmlTemperatureHistory
{
    public void parseXML(GUI gui, int stationCode) throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(System.getProperty("user.dir") + "\\src\\com\\NHLStenden\\Data\\History.xml"));

        NodeList nList = document.getElementsByTagName("observation");

        ArrayList<String> observations = new ArrayList<>();

        ArrayList<NodeList> nodes = new ArrayList<>();
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            NodeList childNodes = nList.item(temp).getChildNodes();
            for(int i = 0; i < childNodes.getLength(); i++)
            {
                Node node = childNodes.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    if (element.getNodeName().equals("station-code"))
                    {
                        if(Integer.parseInt(element.getTextContent()) == stationCode)
                        {
                            nodes.add(childNodes);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < nodes.size(); i++)
        {
            NodeList nodeList = nodes.get(i);
            for(int j = 2; j < nodeList.getLength(); j++)
            {
                Node node = nodeList.item(j);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    if(element.getNodeName().equals("date"))
                    {
                        System.out.println(element.getTextContent());
                    }
                }
            }
        }
    }
}
