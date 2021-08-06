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

// Shows the windspeed for the coming 10 days
public class XmlWindspeedTenDays
{
    // Parses the XML so that it can be read out
    // Does the string building needed to show the string on the GUI
    public void parseXML(GUI gui) throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(System.getProperty("user.dir") + "\\XmlParsing.xml"));

        NodeList nList = document.getElementsByTagName("windSpeed");

        ArrayList<String> windspeeds = new ArrayList<>();

        for (int temp = 1; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                windspeeds.add(element.getAttribute("mps"));
            }
        }
        String tempString = "";
        int count = 1;
        for (String windSpeed : windspeeds)
        {
            tempString = tempString + windSpeed + " m/s on " + LocalDate.now().plusDays(count) + "<br/>";
            count++;
        }
        tempString = "<html><h2>Wind Speed for the next 10 days: </h2>" + tempString + "</html>";
        gui.setWindSpeed(tempString);
    }
}
