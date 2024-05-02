package com.java.swing;

import com.java.file.DateTxt;
import com.java.india.Date;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


public class DateSave extends JFrame implements ActionListener{
    private JTextField jour, mois,an;
    private JButton enregistrerButton,quitterButton,reinitialiserButton;
    private JLabel titre;

    public DateSave() {
  
        setTitle("formulaire Date");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(350,300);
        setResizable(false);
        
      
        jour = new JTextField(10);
        mois = new JTextField(10);
        an=new JTextField(10);
        
        titre= new JLabel("Formulaire Date");

        quitterButton =new JButton("Quitter");
        quitterButton.addActionListener(this);
        reinitialiserButton=new JButton("Reinitialiser");
        reinitialiserButton.addActionListener(this);
        enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener(this);
       
        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(BorderLayout.NORTH,titre);
        
//        Imagearriereplan I = new Imagearriereplan();
        JPanel p2= new JPanel();
        JPanel p3= new JPanel();
        p3.setLayout(new GridLayout(5,2,15,25));
        p3.add(new JLabel("Jour"));p3.add(jour);p3.add(new JLabel("Mois"));
        p3.add(mois);p3.add(new JLabel("Annee"));p3.add(an);
        
        
        JPanel p9=new JPanel();
        JPanel p8= new JPanel();
        p8.setLayout(new BorderLayout());
        JPanel p7 = new JPanel();
        BoxLayout b6=new BoxLayout(p7,BoxLayout.X_AXIS);
        p7.setLayout(b6);
        p7.add(reinitialiserButton);p7.add(enregistrerButton);p7.add(quitterButton);
        p8.add(BorderLayout.SOUTH,p7);
        p9.add(p8);
        
        
        add(p1);add(p3);add(p9);
        setVisible(true);
    }


        public static void main(String[] args) {
            new DateSave();
        }


		public void actionPerformed(ActionEvent e) {
		  if(((JButton)e.getSource()).getText()=="Enregistrer") {
			  String Day=jour.getText();
			  String Month=mois.getText();
			  String Year=an.getText();
		  
			  int day=Integer.parseInt(Day);
			  int month=Integer.parseInt(Month);
			  int year=Integer.parseInt(Year);
			  Date d=new Date(day,month,year);
			  DateTxt dataCli = new DateTxt();
		      dataCli.enregistrerDat(d);
			  JOptionPane.showMessageDialog(null, "Date avec succès");
			  setVisible(false);
		  }
		  
		  else if(((JButton)e.getSource()).getText()=="Quitter") {
			  int choix=JOptionPane.showConfirmDialog(null, "Voulez vous quitter le formulaire ? ", "Confirmer", JOptionPane.YES_NO_OPTION);
			  if(choix==JOptionPane.YES_OPTION) {
				  System.exit(0);

			  }
		  }
		  else {
				jour.setText(" ");
				mois.setText(" ");
				an.setText(" ");
				
			}
		
			
		}
    

}