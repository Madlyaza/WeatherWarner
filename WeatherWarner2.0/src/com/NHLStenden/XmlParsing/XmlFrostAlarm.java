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

public class XmlFrostAlarm
{
    public String parseXML() throws ParserConfigurationException, IOException, SAXException
    {
        String minTemperature = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(System.getProperty("user.dir") + "\\XmlParsing.xml"));

        Element root = document.getDocumentElement();

        NodeList nList = document.getElementsByTagName("temperature");

        for (int temp = 1; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                minTemperature = element.getAttribute("min");
            }
        }
        return minTemperature;
    }

    public boolean checkTemperature(String minTemperature)
    {
        double temperature = 0.0;
        boolean soilFrost = false;
        try
        {
            temperature = Double.parseDouble(minTemperature);
        } catch (NumberFormatException ex)
        {
            System.out.println(ex);
        }
        if (temperature < 5.0)
        {
            soilFrost = true;
        }
        return soilFrost;
    }
}
