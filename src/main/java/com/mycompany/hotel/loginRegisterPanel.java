package com.mycompany.hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class loginRegisterPanel extends JPanel implements ActionListener {

    JButton loginBtn, registerBtn;
    JLabel emailLabel, passwordLabel, wrongLoginLabel;
    JTextField emailField, passwordField;

    public loginRegisterPanel() {
        //this.setSize(Hotel.width, Hotel.height);
        this.setSize(400, 600);
        this.setLayout(null);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 200, 100, 30);
        registerBtn = new JButton("Register");
        registerBtn.setBounds(200, 200, 100, 30);

        emailLabel = new JLabel("Email");
        emailLabel.setLabelFor(emailField);
        emailLabel.setBounds(20, 100, 200, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setLabelFor(passwordField);
        passwordLabel.setBounds(20, 150, 200, 30);

        wrongLoginLabel = new JLabel("Wrong username or password");
        wrongLoginLabel.setBounds(100, 250, 200, 30);
        wrongLoginLabel.setVisible(false);

        emailField = new JTextField();
        emailField.setBounds(100, 100, 200, 30);

        passwordField = new JTextField();
        passwordField.setBounds(100, 150, 200, 30);

        this.add(emailLabel);
        this.add(emailField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginBtn);
        this.add(registerBtn);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn){
            String psw;
            CheckForUserInDB checkForUserInDB = null;
            try {
                checkForUserInDB = new CheckForUserInDB();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                psw = checkForUserInDB.lookIfUserExists(emailField.getText());
                if (psw != null && psw.equals(passwordField.getText())) {
                    //gamePanel.setVisible(true);
                    this.setVisible(false);
                } else {
                    wrongLoginLabel.setVisible(true);
                    System.out.println("Wrong username or password");
                }
            } catch (SQLException ex) {
                System.err.println("Database error: " + ex.getMessage());
            }
        }
    }
}
