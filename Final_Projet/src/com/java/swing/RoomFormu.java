package com.java.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.java.file.RommFileText;
import com.java.india.Room;

public class RoomFormu extends JFrame implements ActionListener{
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
	public static void main(String[] args) {
		new RoomFormu();
		
	}
	public RoomFormu() {
		exp01();
		setTitle("Reservation chambre");
		setSize(350, 300);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	void exp01() {
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		JPanel p2 = new JPanel();
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.X_AXIS));
		ltf1 = new LabeledTextField("Nombre", 10, 150);
		//typeComboBox.setPreferredSize(new Dimension(10, 30));
		//statueComboBox.setPreferredSize(new Dimension(10,30));
		//ltf2 = new LabeledTextField("type", 10, 150);
		//ltf3 = new LabeledTextField("state", 6, 150);
		createComboBox("Type du chambre", typeComboBox, 100,150 );
        createComboBox("Statue du chambre", statueComboBox, 100, 150);
		ltf4 = new LabeledTextField("bedCount", 10, 150);
		ltf5=new LabeledTextField("price", 10, 150);	
		p1.add(ltf1); //p1.add(ltf2);// p1.add(ltf3);
		p1.add(ltf4);p1.add(ltf5);
		p1.add(p3);
		p3.add(typeComboBox);p3.add(statueComboBox);
		saveButton = new JButton("Enregistrer");
		resetButton = new JButton("Réinitialiser");
		exitButton = new JButton("Quitter");
		saveButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
		p2.add(saveButton) ; p2.add(resetButton) ; p2.add(exitButton);
		p.add("Center", p1); p.add("South", p2);
		setContentPane(p); 
	}
	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getText() == "Enregistrer") {
			int number=Integer.parseInt(ltf1.getText());
			int bedCount=Integer.parseInt(ltf4.getText());
			double price = Double.parseDouble(ltf5.getText());
			Room p = new Room( number, bedCount, price);
			verifiertype(typeComboBox,p);
			verifierstate1(statueComboBox,p);
			
	    	//String types = (String) typeComboBox.getSelectedItem();
			//String states = (String) statueComboBox.getSelectedItem();
			
			//int type=Integer.parseInt(typeComboBox.getToolTipText());
			//int state=Integer.parseInt(statueComboBox.getToolTipText());
			
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
			setVisible(false);
		} else if(((JButton)e.getSource()).getText() == "Réinitialiser") {
			int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment Reinitiliser ?", "Confirmation", JOptionPane.YES_NO_OPTION);
	        // Vérification du choix de l'utilisateur
	        if (choix == JOptionPane.YES_OPTION) {
	        	resert();
	        } 
	        
		}
		  else if(((JButton)e.getSource()).getText()=="Quitter") {
			  int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment Quitter ?", "Confirmation", JOptionPane.YES_NO_OPTION);
			  if (choix == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		  }	
	}		
	private void resert() {
		ltf1.setText("");
		//ltf2.setText("");
		//ltf3.setText("");
		ltf4.setText("");
		ltf5.setText("");
		
	}
	 private void createComboBox(String label, JComboBox<String> comboBox, int x, int y) {
	        JLabel jLabel = new JLabel(label);
	        jLabel.setBounds(x, y, 100, 25);
	        add(jLabel);

	        comboBox.setBounds(x + 130, y, 100, 25);
	        add(comboBox);
	    }
	public JComboBox<String> getTypeComboBox() {
		return typeComboBox;
	}
	public void setTypeComboBox(JComboBox<String> typeComboBox) {
		this.typeComboBox = typeComboBox;
	}
	public JComboBox<String> getStatueComboBox() {
		return statueComboBox;
	}
	public void setStatueComboBox(JComboBox<String> statueComboBox) {
		this.statueComboBox = statueComboBox;
	}
	   
    public void verifiertype(JComboBox<String>typecombobox,Room p) {
    	if (typeComboBox.getSelectedItem().toString().equals("Simple")) {
    		p.setType(0);
    	}else {
    		p.setType(1);
    	}
    	
    }
   
    public void verifierstate1(JComboBox<String>statecombobox,Room p) {
    	if (statecombobox.getSelectedItem().toString().equals("Occupée")) {
    		p.setState(1);
    	}else {
    		p.setState(0);
    	}
    }

	 
}
	


