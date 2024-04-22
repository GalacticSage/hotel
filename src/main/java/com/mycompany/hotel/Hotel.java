/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotel;

import javax.swing.*;

/**
 *
 * @author INF3A_usenj
 */
public class Hotel extends JFrame {
    public static int width = 800;
    public static int height = 600;
    loginRegisterPanel loginRegisterPanel = new loginRegisterPanel();
    public Hotel() {
        this.setSize(width, height);
        this.setTitle("Hotel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(loginRegisterPanel);
        this.setVisible(true);
    }

}
