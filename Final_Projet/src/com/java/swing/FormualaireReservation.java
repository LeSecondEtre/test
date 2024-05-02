package com.java.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font;

	public class FormualaireReservation implements ActionListener {
        private static int stop=1;
	    JFrame frame = new JFrame();
	    private JButton saveButton = new JButton("Save");
	    private JButton retourButton = new JButton("Quitte");

	     JTextField idField = new JTextField();
	    private JTextField nomField = new JTextField();

	    private JTextField countryField = new JTextField();

	    JTextField numField = new JTextField();
	    private JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Simple", "Double"});
	    private JComboBox<String> statuePComboBox = new JComboBox<>(new String[]{"Paiement online", "Paiement in place"});
	    private JComboBox<String> typerepasComboBox = new JComboBox<>(new String[]{"Breakfast", "Breakfast and dinner","menu of the day"});
	    
	    //JTextField nombField = new JTextField();
	   // private JTextField prixCField = new JTextField();

	    JTextField dField = new JTextField();
	    private JTextField nbreJField = new JTextField();
	    JLabel titreLabel = new JLabel("HOTEL APP");
		
	

	public FormualaireReservation() {
	 
	    initializeGUI();
	   
	}

	    private void initializeGUI() {
	        frame.setLayout(null);

	        createLabelAndTextField("Client's ID", idField, 50, 50);
	        createLabelAndTextField("Client Name", nomField, 50, 100);
	        createLabelAndTextField("Client country", countryField, 50, 150);
	        createLabelAndTextField("Number of room", numField, 450, 50);
	        createComboBox("Type of room", typeComboBox, 450, 100);
	        createComboBox("Payment", statuePComboBox, 450, 150);
	        createComboBox("Menu of the day ", typerepasComboBox, 450, 200); 
	        //createLabelAndTextField("Nombre de lits", nombField, 450, 200);
	        //createLabelAndTextField("Prix du chambre", prixCField, 450, 250);
	        createLabelAndTextField("Entered Day ", dField, 50, 200);
	        createLabelAndTextField("Number of Day", nbreJField, 50, 250);
	   

	        saveButton.setBounds(400, 500, 100, 40);
	        saveButton.addActionListener(this);
	        retourButton.setBounds(510, 500, 100, 40);
	        retourButton.addActionListener(this);

	        frame.add(saveButton);
	        frame.add(retourButton);

	        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1000, 600);
	        frame.setVisible(true);
	        frame.add(titreLabel);
	    }

	    private void createLabelAndTextField(String label, JTextField textField, int x, int y) {
	        JLabel jLabel = new JLabel(label);
	        jLabel.setBounds(x, y, 200, 25);
	        frame.add(jLabel);

	        textField.setBounds(x + 130, y, 100, 25);
	        frame.add(textField);
	    }

	    private void createComboBox(String label, JComboBox<String> comboBox, int x, int y) {
	        JLabel jLabel = new JLabel(label);
	        jLabel.setBounds(x, y, 200, 25);
	        frame.add(jLabel);

	        comboBox.setBounds(x + 130, y, 100, 25);
	        frame.add(comboBox);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == retourButton ) {
	            frame.dispose();
	            // You might want to perform additional cleanup or navigation logic here
	        } else if (e.getSource() == saveButton) {
	        	gestionReservation a=new gestionReservation();
	        	if (typeComboBox.getSelectedItem().toString().equals("Simple")) {
	        		if (a.verifierdisponibilitéS()==true) {
	        	       RoomFormu room=new RoomFormu();
	        	       ClientGUI client=new ClientGUI();
	                  // enregistrerDansFichier();
	                  DateSave k=new DateSave();
	                  gestionReservation.getincrementerCpS();  
	        		}
	        		else {
	        			JOptionPane.showMessageDialog(null, "ALL OF SIMPLE ROOM ARE OCCURED");
	        			
	        		}
	        }
	        	else if (typeComboBox.getSelectedItem().toString().equals("Double")){
	        		if (a.verifierdisponibilitéD()==true) {
	 	        	   RoomFormu room=new RoomFormu();
	 	               //enregistrerDansFichier();
	 	               DateSave d=new DateSave();
	 	               gestionReservation.getincrementerCpD();  
	 	        		}
	 	        		else {
	 	        			JOptionPane.showMessageDialog(null, "ALL OF DOUBLE ROOM ARE OCCURED");
	 	        			
	 	        		}
	     	
	        }
	    }
	   }
	    private void enregistrerDansFichier() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//Elite//Desktop//india//res.txt", true))) {
	            writer.write("Id : " + idField.getText() + "\n");
	            writer.write("Nom : " + nomField.getText() + "\n");
	            writer.write("Country : " + countryField.getText()+"\n");
	            writer.write("Numero : " + numField.getText() + "\n");
	            //writer.write("Nombre de lits : " + nombField.getText() + "\n");
	           // writer.write("Prix : " + prixCField.getText() + "\n");
	            writer.write("Date d'entree :" + dField.getText()+ "\n");
	            writer.write("Nombre de jours : " + nbreJField.getText() + "\n");
	            writer.write("\n");
	            resetFields();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private void resetFields() {
	        idField.setText("");
	        nomField.setText("");
	      
	        countryField.setText("");
	        numField.setText("");
	        //nombField.setText("");
	       // prixCField.setText("");
	       
	        nbreJField.setText("");
	       // prixCField.setText("");
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(FormualaireReservation::new);
	    }
	}	