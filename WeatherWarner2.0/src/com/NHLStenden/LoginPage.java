package com.NHLStenden;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginPage implements ActionListener
{
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton registerButton = new JButton("Register");
    JTextField userNameField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userNameLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel("");
    GUI gui;

    public LoginPage()
    {
        /**
         * Constructor for the login page, contains username field, password field, login button, reset button and a register button.
         */
        userNameLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,350,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userNameField.setBounds(125,100,250,25);
        userPasswordField.setBounds(125,150,250,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.addActionListener(this);

        registerButton.setBounds(325,200,100,25);
        registerButton.addActionListener(this);


        frame.add(userNameLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userNameField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(registerButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     *
     * @param e when a button is pressed, take the correct actions for the button.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==resetButton)
        {
            userNameField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource()==registerButton)
        {
            RegisterPage registerPage = new RegisterPage();
        }

        if (e.getSource()==loginButton)
        {
            String userName = userNameField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());
            String userPasswordDB = "";
            Connect connect = new Connect();
            userPasswordDB = connect.getPassword(userName);

            if (Objects.equals(userName, "") || userPassword.equals(""))
            {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Empty fields detected!");
            }
            else
            {
                if (userPassword.equals(userPasswordDB))
                {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login successful");
                    this.gui = new GUI();
                } else
                {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Invalid Username or Password!");
                }
            }
        }
    }

    public GUI getGui()
    {
        return gui;
    }
}
