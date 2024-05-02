package com.java.swing;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GestionHotelApp {
	
    private static JFrame mainFrame;
    private static AuthenticationForm authenticationForm;
  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            mainFrame = new JFrame("Menu Principal - Gestion Hôtel");
            mainFrame.setLayout(new BorderLayout());
            JPanel panneau = new JPanel();
            JPanel p1 = new JPanel();
            p1.setLayout(new GridLayout(5, 1, 10, 25));
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(350, 300);
            mainFrame.setResizable(false);
          
            JLabel titre = new JLabel("Gestion Hôtel:");
            mainFrame.add(BorderLayout.NORTH, titre); 

            JButton clientButton = new JButton("Check the hotel customer list");
            JButton chambreButton = new JButton("Check the list's of room occured");
            JButton reservationButton = new JButton("Performe a booking room");
            JButton occupationButton = new JButton("Check reservations'check");
            JButton deconnexionButton = new JButton("Deconnect");
       
           reservationButton.addActionListener(e -> showForm("Effectuer reservation", new FormualaireReservation().frame));
           deconnexionButton.addActionListener(e -> confirmDeconnexion());
           clientButton.addActionListener(e ->display("Consulter liste des clients"));
           occupationButton.addActionListener(e ->displayR("Consulter la liste des reservations"));
           chambreButton.addActionListener(e ->displayC("Consulter la liste des chambres reserves"));
      
            p1.add(reservationButton);
            p1.add(clientButton);
            p1.add(chambreButton);
            p1.add(occupationButton);
            p1.add(deconnexionButton);
            panneau.add(p1);
            mainFrame.add(BorderLayout.CENTER, panneau);

            authenticationForm = new AuthenticationForm(mainFrame);
            authenticationForm.setVisible(true);
        });
    }
    
    
    private static void showForm(String formName, JFrame form) {
        form.setTitle(formName);
        form.setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setVisible(true);
    }
 
    private static void display (String formName) {
    	if(formName == "Consulter liste des clients") {
             new LectureFichierTexteClient();
  }
    }
    
    private static void displayR (String formName) {
    	if(formName == "Consulter la liste des reservations") {
             new LectureRoom();
  }
    }
    
    private static void displayC (String formName) {
    	if(formName == "Consulter la liste des chambres reserves") {
             new LectureChambre();
  }
    }
    
   
    
    private static void handleDeconnexion() {
        authenticationForm.resetFields();
        authenticationForm.setVisible(true);
        mainFrame.dispose();
    }
    private static void confirmDeconnexion() {
        int choice = JOptionPane.showConfirmDialog(mainFrame, "Voulez-vous vraiment vous déconnecter?", "Confirmation de déconnexion", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            handleDeconnexion();
        }
    }

//	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText()=="Consulter la liste des chambres reserves") {
			new LectureFichierTexteClient();
		}
	}

}

class AuthenticationForm extends JFrame implements ActionListener {

    private JFrame parentFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public AuthenticationForm(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initializeGUI();
        
    }
    
    private void initializeGUI() {
        setTitle("Authentification");
        setLayout(new GridLayout(4, 1, 10, 10));
        
  
        JLabel titleLabel = new JLabel("Authentification");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);
     

        JPanel usernamePanel = new JPanel();
        JLabel usernameLabel = new JLabel("User name :");
        usernameField = new JTextField(20);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        add(usernamePanel);
        

        JPanel passwordPanel = new JPanel();
        JLabel passwordLabel = new JLabel("Password : ");
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        add(passwordPanel);

        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Connect");
        loginButton.addActionListener(this);
        buttonPanel.add(loginButton);
        add(buttonPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        authenticate();
    }

    private void authenticate() {
       // Simuler l'authentification avec un nom d'utilisateur et un mot de passe statiques
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();

        if ("ensam".equals(username) && "cs50".equals(new String(password))) {
            setVisible(false);
            parentFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Authentification Failed");
        }
    }

    public void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
    }
    
    
    
}
