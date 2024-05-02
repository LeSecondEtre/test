package com.java.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.java.file.RommFileText;
import com.java.india.Room;


public class RoomForm extends JPanel implements ActionListener {
	private LabeledTextField ltf1;
	//private LabeledTextField ltf2;
	//private LabeledTextField ltf3;
	private JComboBox<String>typeComboBox=new JComboBox<>(new String[]{"Simple","Double"});
	private JComboBox<String>statueComboBox=new JComboBox<>(new String[]{"Libre","Occupée"});
	private LabeledTextField ltf4;
	private LabeledTextField ltf5;
	
	private JButton saveButton;
	private JButton resetButton;
	private JButton exitButton;

	public RoomForm() {
		this.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		JPanel p2 = new JPanel();
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.X_AXIS));
		ltf1 = new LabeledTextField("number", 8, 150);
		//typeComboBox.setPreferredSize(new Dimension(10, 30));
		//statueComboBox.setPreferredSize(new Dimension(10,30));
		//ltf2 = new LabeledTextField("type", 10, 150);
		//ltf3 = new LabeledTextField("state", 6, 150);
		createComboBox(typeComboBox,450,100);
		createComboBox(statueComboBox,450,100);
		ltf4 = new LabeledTextField("bedCount", 6, 150);
		ltf5=new LabeledTextField("price", 6, 150);	
		p1.add(ltf1); //p1.add(ltf2);// p1.add(ltf3);
		p1.add(ltf4);p1.add(ltf5);
		p1.add(p3);
		p3.add(typeComboBox);p3.add(statueComboBox);
		saveButton = new JButton("Sauvegarder");
		resetButton = new JButton("Réinitialiser");
		exitButton = new JButton("Quitter");
		saveButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
		p2.add(saveButton) ; p2.add(resetButton) ; p2.add(exitButton);
		
		add("Center", p1); add("South", p2);
	}

	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getText() == "Sauvegarder") {
			int number=Integer.parseInt(ltf1.getText());
			String type=typeComboBox.getToolTipText();
			String state=statueComboBox.getToolTipText();
			//int type=Integer.parseInt(typeComboBox.getToolTipText());
			//int state=Integer.parseInt(statueComboBox.getToolTipText());
			
			int bedCount=Integer.parseInt(ltf4.getText());
			double price = Double.parseDouble(ltf5.getText());
			Room p = new Room();
			//RommFileText datachambre=new RommFileText();
			/*/
			RommFileText.ecriredansFichier("C://Users/hp/Desktop/room.txt",ltf1.getText(),true);
			RommFileText.ecriredansFichier("C://Users/hp/Desktop/room.txt",ltf2.getText(),true);
			RommFileText.ecriredansFichier("C://Users/hp/Desktop/room.txt",ltf3.getText(),true);
			RommFileText.ecriredansFichier("C://Users/hp/Desktop/room.txt",ltf4.getText(),true);
			RommFileText.ecriredansFichier("C://Users/hp/Desktop/room.txt",ltf5.getText(),true);/*/
			//RommFileText.ecriredansFichier("room.txt", Room.toString(), true);
			RommFileText.ecriredansFichier(p);
			System.out.println(p);
			JOptionPane.showMessageDialog(null, "Room bien réservée");
			RommFileText rommFileText = new RommFileText();
			rommFileText.lireFichier("room.txt");
			resert();
		} else if(((JButton)e.getSource()).getText() == "Réinitialiser") {
			int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment Reinitiliser ?", "Confirmation", JOptionPane.YES_NO_OPTION);
	        // Vérification du choix de l'utilisateur
	        if (choix == JOptionPane.YES_OPTION) {
	        	resert();
	        } 
	        
		}
		  else if(((JButton)e.getSource()).getText()=="Quitter") {
			System.exit(0);
		}
			
	}		
	private void resert() {
		ltf1.setText("");
		//ltf2.setText("");
		//ltf3.setText("");
		ltf4.setText("");
		ltf5.setText("");
		
	}
	private void createComboBox(JComboBox<String>comboBox,int x,int y) {
		//JLabel jLabel=new JLabel(label);
		//jLabel.setBounds(x,y,200,100);
		comboBox.setBounds(x+450,y+100,200,100);
	
	}
	   }

    



