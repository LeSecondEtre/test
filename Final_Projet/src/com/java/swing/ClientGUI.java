package com.java.swing;

import javax.swing.*;

import com.java.file.FileTxt;
import com.java.india.Client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Cette classe s'occupe de l'enregistrement des données d'un client à travers un Formulaire

//Chose à Faire : Redefinire le positionnement des JButtons , Mettre une image arrière plan

public class ClientGUI extends JFrame implements ActionListener{
    private JTextField idField, nomField, villeField, paysField,prenomField;
    private JButton enregistrerButton,quitterButton,reinitialiserButton;
    private JLabel titre;

    public ClientGUI() {
    	//fenetre
        setTitle("Formulaire Customer");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(350,300);
        setResizable(true);
        
        /*// Image arrière-plan
        ImageIcon backgroundImage = new ImageIcon("P.jpeg");
        Image image = backgroundImage.getImage();
        Image scaledImage = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(scaledImage);

        // Label d'arrière-plan
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);
        getLayeredPane().setLayout(new BorderLayout());*/

        
        //les obj graphik
        idField = new JTextField(10);
        nomField = new JTextField(10);
        prenomField=new JTextField(10);
        villeField = new JTextField(10);
        paysField = new JTextField(10);
        
        titre= new JLabel("Form Client");

        quitterButton =new JButton("Quite");
        quitterButton.addActionListener(this);
        reinitialiserButton=new JButton("Reset");
        reinitialiserButton.addActionListener(this);
        enregistrerButton = new JButton("Saved");
        enregistrerButton.addActionListener(this);
        
        //sous panneaux
        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(BorderLayout.NORTH,titre);
        
        JPanel p2= new JPanel();
        JPanel p3= new JPanel();
        p3.setLayout(new GridLayout(5,2,15,25));
        p3.add(new JLabel("Id : "));p3.add(idField);p3.add(new JLabel("LastName :"));
        p3.add(nomField);p3.add(new JLabel("FirstName :"));p3.add(prenomField);
        p3.add(new JLabel("Town : "));p3.add(villeField);p3.add(new JLabel("Country"));
        p3.add(paysField);
        p2.add(p3);
        
        JPanel p9=new JPanel();
        JPanel p8= new JPanel();
        p8.setLayout(new BorderLayout());
        JPanel p7 = new JPanel();
        BoxLayout b6=new BoxLayout(p7,BoxLayout.X_AXIS);
        p7.setLayout(b6);
        p7.add(reinitialiserButton);p7.add(enregistrerButton);p7.add(quitterButton);
        p8.add(BorderLayout.SOUTH,p7);
        p9.add(p8);
        
        //panneau principal
        add(p1);add(p3);add(p9);
        //affichage de la fenetre
        setVisible(true);
    }


        public static void main(String[] args) {
            // Créez et affichez l'interface graphique directement
            new ClientGUI();
        }


		public void actionPerformed(ActionEvent e) {
		  if(((JButton)e.getSource()).getText()=="Enregistrer") {
			  String nom=nomField.getText();
			  String prenom=prenomField.getText();
			  String id=idField.getText();
			  String ville=villeField.getText();
			  String pays=paysField.getText();
			  Client cli=new Client(id,nom,prenom,ville);
			  FileTxt dataCli = new FileTxt();
		      dataCli.enregistrerCli(cli);
			  JOptionPane.showMessageDialog(null, "Customer saved");
			  setVisible(false);
		  }
		  else if(((JButton)e.getSource()).getText()=="quitter") {
			  int choix=JOptionPane.showConfirmDialog(null, "Do you really want to quite this form", "Confirm", JOptionPane.YES_NO_OPTION);
			  if(choix==JOptionPane.YES_OPTION) {
				  System.exit(0);
			  }

		  }
		  else {
				idField.setText(" ");
				nomField.setText(" ");
				prenomField.setText(" ");
				villeField.setText(" ");
				paysField.setText(" ");
			}
				
		}
		
    

}
