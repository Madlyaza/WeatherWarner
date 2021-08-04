package com.NHLStenden;

import javax.swing.*;
import java.awt.*;

public class GUI
{
    private final JPanel panelAlarms;
    private final JPanel panelMinMaxTemp;
    private final JPanel panelWindDirection;
    private final JFrame frame;
    private final JTabbedPane tabbedPane;
    private final Dimension screensize;

    private final JLabel heatWarning;
    private final JLabel frostWarning;
    private final JLabel precipitationWarning;
    private final JLabel temperatures;

    public GUI()
    {
        heatWarning = new JLabel("");
        frostWarning = new JLabel("");
        precipitationWarning = new JLabel("");
        temperatures = new JLabel("");
        tabbedPane = new JTabbedPane();
        frame = new JFrame();
        panelAlarms = new JPanel();
        panelMinMaxTemp = new JPanel();
        panelWindDirection = new JPanel();
        screensize = Toolkit.getDefaultToolkit().getScreenSize();



        panelAlarms.add(heatWarning);
        panelAlarms.add(frostWarning);
        panelAlarms.add(precipitationWarning);

        panelAlarms.setLayout(new GridLayout(3, 0));
        tabbedPane.addTab("Alarms", panelAlarms);


        panelMinMaxTemp.add(temperatures);

        panelMinMaxTemp.setLayout(new GridLayout(5, 0));
        tabbedPane.addTab("Temperatures", panelMinMaxTemp);



        panelWindDirection.setLayout(new GridLayout(5, 0));
        tabbedPane.addTab("Wind", panelWindDirection);

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
}
