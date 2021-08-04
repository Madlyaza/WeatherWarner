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

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

public class XmlHeatAlarm
{
    public String parseXML() throws ParserConfigurationException, IOException, SAXException
    {
        String maxTemperature = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(System.getProperty("user.dir") + "\\XmlParsing.xml"));

        NodeList nList = document.getElementsByTagName("temperature");

        for (int temp = 1; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                maxTemperature = element.getAttribute("max");
            }
        }
        return maxTemperature;
    }

    public boolean checkTemperature(String maxTemperature)
    {
        double temperature = 0.0;
        boolean heatDamage = false;
        try
        {
            temperature = Double.parseDouble(maxTemperature);
        } catch (NumberFormatException ex)
        {
            System.out.println(ex);
        }
        if (temperature > 25)
        {
            heatDamage = true;
            System.out.println("Heat detected for tomorrow.");
        }
        return heatDamage;
    }
}
