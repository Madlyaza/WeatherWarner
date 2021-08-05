package com.NHLStenden.XmlParsing;

import com.NHLStenden.GUI;
import com.sun.tools.jconsole.JConsoleContext;
import com.sun.tools.jconsole.JConsolePlugin;
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
import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

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

        String holdingDate = "";
        ArrayList<ArrayList> monthlyNumbers = new ArrayList<>();
        ArrayList<Double> tempList = new ArrayList<>();
        for (NodeList nodeList : nodes)
        {
            Node dateNode = nodeList.item(3);
            Node tempNode = nodeList.item(5);
            if (dateNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element dateElement = (Element) dateNode;
                Element tempElement = (Element) tempNode;
                if (dateElement.getNodeName().equals("date"))
                {
                    String[] stringArray = dateElement.getTextContent().split("-");
                    if (!stringArray[1].equals(holdingDate))
                    {
                        monthlyNumbers.add(tempList);
                        tempList = new ArrayList<>();
                        holdingDate = stringArray[1];
                    }
                    if(!Objects.equals(tempElement.getTextContent(), ""))
                    {
                        tempList.add(Double.parseDouble(tempElement.getTextContent()));
                    }
                }
            }
        }

        for (ArrayList list:monthlyNumbers)
        {
            double sum = 0.0;
            if (!list.isEmpty())
            {
                for(Object i : list)
                {
                    sum += ((Number) i ).doubleValue();
                }
                Double average = (sum / list.size()) / 10; // Divide by 10 since the XML has it in 0.1 Celsius
                System.out.println(average);
            }
        }
    }
}
