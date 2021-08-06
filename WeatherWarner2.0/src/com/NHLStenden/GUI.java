package com.NHLStenden;

import javax.swing.*;
import java.awt.*;

public class GUI
{
    private final JPanel panelAlarms;
    private final JPanel panelMinMaxTemp;
    private final JPanel panelWind;
    private final JPanel panelAverageTemperature;
    private final JFrame frame;
    private final JTabbedPane tabbedPane;
    private final Dimension screensize;

    private final JLabel heatWarning;
    private final JLabel frostWarning;
    private final JLabel precipitationWarning;
    private final JLabel maxTemperature;
    private final JLabel minTemperature;
    private final JLabel windDirection;
    private final JLabel windSpeed;
    private final JLabel averageTemps20Years;

    public GUI()
    {
        heatWarning = new JLabel("Heat");
        frostWarning = new JLabel("Frost");
        precipitationWarning = new JLabel("Precipitation");
        maxTemperature = new JLabel("Max");
        minTemperature = new JLabel("Min");
        windDirection = new JLabel("Direction");
        windSpeed = new JLabel("Speed");
        averageTemps20Years = new JLabel("Average temperatures for the last 20 years per month");

        tabbedPane = new JTabbedPane();
        frame = new JFrame();
        panelAlarms = new JPanel();
        panelMinMaxTemp = new JPanel();
        panelWind = new JPanel();
        panelAverageTemperature = new JPanel();
        screensize = Toolkit.getDefaultToolkit().getScreenSize();

        panelAlarms.add(heatWarning);
        panelAlarms.add(frostWarning);
        panelAlarms.add(precipitationWarning);

        panelAlarms.setLayout(new GridLayout(3, 0));
        JScrollPane scroller4 = new JScrollPane(panelAlarms);
        scroller4.getVerticalScrollBar().setUnitIncrement(16);
        tabbedPane.addTab("Alarms", scroller4);


        panelMinMaxTemp.add(minTemperature);
        panelMinMaxTemp.add(maxTemperature);

        panelMinMaxTemp.setLayout(new GridLayout(2, 0));
        JScrollPane scroller3 = new JScrollPane(panelMinMaxTemp);
        scroller3.getVerticalScrollBar().setUnitIncrement(16);
        tabbedPane.addTab("Temperatures", scroller3);

        panelWind.add(windDirection);
        panelWind.add(windSpeed);

        panelWind.setLayout(new GridLayout(2, 0));
        JScrollPane scroller2 = new JScrollPane(panelWind);
        scroller2.getVerticalScrollBar().setUnitIncrement(16);
        tabbedPane.addTab("Wind", scroller2);

        panelAverageTemperature.add(averageTemps20Years);

        panelAverageTemperature.setLayout(new GridLayout(1, 0));
        JScrollPane scroller = new JScrollPane(panelAverageTemperature);
        scroller.getVerticalScrollBar().setUnitIncrement(16);
        tabbedPane.addTab("Average Temperature 20 Years", scroller);

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(tabbedPane));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(tabbedPane));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Weather Warner");
        frame.pack();
        frame.setSize(screensize.width, screensize.height);
        frame.setVisible(true);
    }

    public void setHeatWarningText(String text)
    {
        heatWarning.setText(text);
    }

    public void setFrostWarningText(String text)
    {
        frostWarning.setText(text);
    }

    public void setPrecipitationWarningText(String text)
    {
        precipitationWarning.setText(text);
    }

    public void setMaxTemperature(String text)
    {
        maxTemperature.setText(text);
    }

    public void setMinTemperature(String text)
    {
        minTemperature.setText(text);
    }

    public void setWindDirection(String text)
    {
        windDirection.setText(text);
    }

    public void setWindSpeed(String text)
    {
        windSpeed.setText(text);
    }

    public void setAverageTemps20Years(String text)
    {
        averageTemps20Years.setText(text);
    }
}
