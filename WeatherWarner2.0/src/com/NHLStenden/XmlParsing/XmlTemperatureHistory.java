package com.NHLStenden.XmlParsing;

import com.NHLStenden.GUI;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        String fullDate = "";
        ArrayList<ArrayList> averageTempWithDate = new ArrayList<>();
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
                        double sum = 0.0;
                        if (!tempList.isEmpty())
                        {
                            for(Number i : tempList)
                            {
                                sum += i.doubleValue();
                            }
                            Double average = (sum / tempList.size()) / 10; // Divide by 10 since the XML has it in 0.1 Celsius
                            ArrayList<Object> avgList = new ArrayList<>();
                            avgList.add(average);
                            avgList.add(fullDate);
                            averageTempWithDate.add(avgList);
                        }

                        tempList = new ArrayList<>();
                        holdingDate = stringArray[1];
                        fullDate = dateElement.getTextContent();

                    }
                    if(!Objects.equals(tempElement.getTextContent(), ""))
                    {
                        tempList.add(Double.parseDouble(tempElement.getTextContent()));
                    }
                }
            }
        }

        LocalDate minus20 =  LocalDate.now().minusYears(20);
        for(ArrayList tempsAndDates : averageTempWithDate)
        {
            String[] tempDate = tempsAndDates.get(1).toString().split("T");
            LocalDate currentDate = LocalDate.parse(tempDate[0]);
            if (minus20.isBefore(currentDate))
            {
                
            }
        }
    }
}
