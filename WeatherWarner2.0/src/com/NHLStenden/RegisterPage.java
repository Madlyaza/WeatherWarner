package com.NHLStenden;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class RegisterPage implements ActionListener
{
    JFrame frame = new JFrame();
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JTextField userNameField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JPasswordField userPasswordConfirmField = new JPasswordField();
    JLabel userNameLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel userPasswordConfirmLabel = new JLabel("Confirm password:");
    JLabel messageLabel = new JLabel("");

    public RegisterPage()
    {
        messageLabel.setBounds(125,250,350,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userNameLabel.setBounds(50,100,125,25);
        userPasswordLabel.setBounds(50,150,125,25);
        userPasswordConfirmLabel.setBounds(50,200,125,25);

        userNameField.setBounds(175,100,250,25);
        userPasswordField.setBounds(175,150,250,25);
        userPasswordConfirmField.setBounds(175,200,250,25);

        registerButton.setBounds(125,250,100,25);
        registerButton.addActionListener( this);

        resetButton.setBounds(225,250,100,25);
        resetButton.addActionListener( this);

        frame.add(userNameLabel);
        frame.add(userNameField);
        frame.add(messageLabel);
        frame.add(userPasswordLabel);
        frame.add(userPasswordField);
        frame.add(userPasswordConfirmLabel);
        frame.add(userPasswordConfirmField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520,420);
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
            userPasswordConfirmField.setText("");
            messageLabel.setText("");
        }

        if (e.getSource()== registerButton)
        {
            String userName = userNameField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());
            String userPasswordConfirm = String.valueOf(userPasswordConfirmField.getPassword());
            Connect connect = new Connect();

            if (Objects.equals(userName, "") || userPassword.equals(""))
            {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Empty fields detected!");
            }
            else
            {
                if (userPassword.equals(userPasswordConfirm))
                {
                    if(connect.userExists(userName))
                    {
                        connect.addUser(userName, userPassword);
                        messageLabel.setForeground(Color.GREEN);
                        messageLabel.setText("Register successful");
                        GUI gui = new GUI();
                    }
                    else
                    {
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("Username is already taken!");
                    }
                }
                else
                {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Passwords are not equal");
                }
            }
        }
    }
}

