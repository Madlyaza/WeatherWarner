package com.NHLStenden.XmlParsing;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class XmlThreeHoursForecast
{
    public void parseXML() throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File( System.getProperty("user.dir") + "\\XmlParsing.xml" ));

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        NodeList nList = document.getElementsByTagName("precipitation");
        System.out.print("============================");

        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            System.out.println("");
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                System.out.println(element.getAttribute("probability"));
            }
        }
    }

}
