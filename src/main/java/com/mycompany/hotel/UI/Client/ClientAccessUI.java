package UI.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientAccessUI extends JFrame implements ActionListener {


    public static void main(String[] args) {
        new ClientAccessUI();
    }


    public static final int SCREEN_WIDTH = 400;
    public static final int SCREEN_HEIGHT = 400;

    private ClientLoginPanel clientLoginPanel = new ClientLoginPanel(this);
    private JPanel currPanel = clientLoginPanel;

    private JMenuBar jMenuBar = new JMenuBar();
    private JMenuItem loginMenu = new JMenuItem("Login");
    private JMenuItem registerMenu = new JMenuItem("Register");






    ClientAccessUI(){

        MenubarSetup();


        setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));


        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }




    private void MenubarSetup(){
        loginMenu.addActionListener(this);
        registerMenu.addActionListener(this);

        jMenuBar.add(loginMenu);
        jMenuBar.add(registerMenu);
        this.setJMenuBar(jMenuBar);
    }





    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == loginMenu){
            System.out.println("Login Panel");
        }

    }
}
