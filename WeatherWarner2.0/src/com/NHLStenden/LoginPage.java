package com.NHLStenden;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener
{
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userNameField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userNameLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel("Moi hoe is het nou dan?");

    public LoginPage()
    {
        userNameLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,100,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userNameField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.addActionListener(this);

        frame.add(userNameLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userNameField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(240,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==resetButton)
        {
            userNameField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource()==loginButton)
        {
            String userName = userNameField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());

            if (userName == "admin")
            {
                if (userPassword == "moin");
                {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login successful");
                    GUI gui = new GUI();
                }
            }

        }
    }
}