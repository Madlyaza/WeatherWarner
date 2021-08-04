package com.NHLStenden;

import javax.swing.*;
import java.awt.*;

public class GUI
{
    private final JPanel panelAlarms;
    private final JPanel panelMinMaxTemp;
    private final JPanel panelWind;
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

    public GUI()
    {
        heatWarning = new JLabel("Heat");
        frostWarning = new JLabel("Frost");
        precipitationWarning = new JLabel("Precipitation");
        maxTemperature = new JLabel("Max");
        minTemperature = new JLabel("Min");
        windDirection = new JLabel("Direction");
        windSpeed = new JLabel("Speed");

        tabbedPane = new JTabbedPane();
        frame = new JFrame();
        panelAlarms = new JPanel();
        panelMinMaxTemp = new JPanel();
        panelWind = new JPanel();
        screensize = Toolkit.getDefaultToolkit().getScreenSize();

        panelAlarms.add(heatWarning);
        panelAlarms.add(frostWarning);
        panelAlarms.add(precipitationWarning);

        panelAlarms.setLayout(new GridLayout(10, 0));
        tabbedPane.addTab("Alarms", panelAlarms);


        panelMinMaxTemp.add(minTemperature);
        panelMinMaxTemp.add(maxTemperature);

        panelMinMaxTemp.setLayout(new GridLayout(4, 0));
        tabbedPane.addTab("Temperatures", panelMinMaxTemp);

        panelWind.add(windDirection);
        panelWind.add(windSpeed);

        panelWind.setLayout(new GridLayout(4, 0));
        tabbedPane.addTab("Wind", panelWind);

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
}
