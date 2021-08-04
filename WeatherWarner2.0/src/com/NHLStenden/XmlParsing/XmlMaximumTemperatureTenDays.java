package com.NHLStenden.XmlParsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XmlMaximumTemperatureTenDays
{
    public void parseXML() throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        try
        {
            Document document = builder.parse(new File(System.getProperty("user.dir") + "\\XmlParsing.xml"));
            NodeList nList = document.getElementsByTagName("temperature");
            ArrayList<String> maximumTemperatures = new ArrayList<>();

            for (int i = 1; i < nList.getLength(); i++)
            {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    maximumTemperatures.add(element.getAttribute("max") + "\u00B0C is the maximum temperature for day " + i);
                }
            }
            for (String max:maximumTemperatures)
            {
                System.out.println(max);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Check XML file for more information");
            ex.printStackTrace();
        }
    }
}
