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
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class XmlPrecipitationHistory
{
    public void parseXML(GUI gui, String stationName) throws ParserConfigurationException, IOException, SAXException
    {
        int stationCode = getStationCode(stationName.toLowerCase(Locale.ROOT));
        if (stationCode == -1)
        {
            System.out.println("The station does not exist please choose one that exists.");
            return;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(System.getProperty("user.dir") + "\\src\\com\\NHLStenden\\Data\\History.xml"));

        NodeList nList = document.getElementsByTagName("observation");

        ArrayList<NodeList> nodes = new ArrayList<>();
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            NodeList childNodes = nList.item(temp).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++)
            {
                Node node = childNodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    if (element.getNodeName().equals("station-code"))
                    {
                        if (Integer.parseInt(element.getTextContent()) == stationCode)
                        {
                            nodes.add(childNodes);
                        }
                    }
                }
            }
        }

        String holdingDate = "";
        String fullDate = "";
        ArrayList<ArrayList> averagePrecWithDate = new ArrayList<>();
        ArrayList<Double> tempList = new ArrayList<>();
        for (NodeList nodeList : nodes)
        {
            Node dateNode = nodeList.item(3);
            Node rainNode = nodeList.item(7);
            if (dateNode.getNodeType() == Node.ELEMENT_NODE && rainNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element dateElement = (Element) dateNode;
                Element tempElement = (Element) rainNode;
                if (dateElement.getNodeName().equals("date"))
                {
                    String[] stringArray = dateElement.getTextContent().split("-");
                    if (!stringArray[1].equals(holdingDate))
                    {
                        double sum = 0.0;
                        if (!tempList.isEmpty())
                        {
                            for (Number i : tempList)
                            {
                                sum += i.doubleValue();
                            }
                            Double average = (sum / tempList.size()) / 10; // Divide by 10 since the XML has it in 0.1 mm
                            ArrayList<Object> avgList = new ArrayList<>();
                            avgList.add(average);
                            avgList.add(fullDate);
                            averagePrecWithDate.add(avgList);
                        }

                        tempList = new ArrayList<>();
                        holdingDate = stringArray[1];
                        fullDate = dateElement.getTextContent();

                    }
                    if (!Objects.equals(tempElement.getTextContent(), ""))
                    {
                        tempList.add(Double.parseDouble(tempElement.getTextContent()));
                    }
                }
            }
        }

        LocalDate minus20 = LocalDate.now().minusYears(20);
        String rainString = "";
        DecimalFormat df = new DecimalFormat("#.#");
        for (ArrayList rainAndDates : averagePrecWithDate)
        {
            String[] tempDate = rainAndDates.get(1).toString().split("T");
            LocalDate currentDate = LocalDate.parse(tempDate[0]);
            String[] mAndY = rainAndDates.get(1).toString().split("-");
            if (minus20.isBefore(currentDate))
            {
                rainString = rainString + df.format(rainAndDates.get(0)) + " mm was the average precipitation for " + mAndY[0] + "-" + mAndY[1] + "<br/>";
            }
        }
        rainString = "<html><h2>The average precipitation per month for the past 20 years in " + stationName + " were: </h2>" + rainString + "</html>";
        gui.setAverageRain20Years(rainString);
    }

    public int getStationCode(String stationName) throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(System.getProperty("user.dir") + "\\src\\com\\NHLStenden\\Data\\WeatherStations.xml"));

        NodeList nList = document.getElementsByTagName("stations");

        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            NodeList childNodes = nList.item(temp).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++)
            {
                Node node = childNodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    if (element.getAttribute("stationName").toLowerCase(Locale.ROOT).equals(stationName))
                    {
                        return Integer.parseInt(element.getAttribute("stationCode"));
                    }
                }
            }
        }
        return -1;
    }
}
