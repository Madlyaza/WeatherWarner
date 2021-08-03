package com.NHLStenden.XmlParsing;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

import static java.lang.Integer.parseInt;

public class XmlPrecipitationAlarm
{
    public boolean parseXML() throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(System.getProperty("user.dir") + "\\XmlParsing.xml"));

        NodeList nList = document.getElementsByTagName("precipitation");

        for (int temp = 1; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                if (element.getAttribute("type").equals("rain"))
                {
                    if ((Double.parseDouble(element.getAttribute("value")) / 3) > 10)
                    {
                        System.out.println("there will be " + (Double.parseDouble(element.getAttribute("value")) / 3) + " mm/h of rain");
                        return true;
                    }
                }
                else if (element.getAttribute("type").equals("snow"))
                {
                    if ((Double.parseDouble(element.getAttribute("value")) / 3) > 50)
                    {
                        System.out.println("there will be " + (Double.parseDouble(element.getAttribute("value")) / 3) + " mm/h of snow");
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
