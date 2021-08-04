package com.NHLStenden.XmlParsing;

import com.NHLStenden.GUI;
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
import java.time.LocalDate;
import java.util.ArrayList;

public class XmlWindDirectionTenDays
{
    public void parseXML(GUI gui) throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(System.getProperty("user.dir") + "\\XmlParsing.xml"));

        NodeList nList = document.getElementsByTagName("windDirection");

        ArrayList<String> windDirections = new ArrayList<>();

        for (int temp = 1; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                windDirections.add(element.getAttribute("name"));
            }
        }
        String tempString = "";
        int count = 1;
        for (String direction : windDirections)
        {
            tempString = tempString + direction + " on " + LocalDate.now().plusDays(count) +"<br/>";
            count++;
        }
        tempString = "<html><h2>Wind Directions for the next 10 days: </h2>" + tempString + "</html>";
        gui.setWindDirection(tempString);
    }
}
