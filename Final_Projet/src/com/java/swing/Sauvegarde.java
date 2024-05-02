package com.java.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.java.file.RommFileText;

public class Sauvegarde extends JFrame{
	public static void main(String[] args) {
		new Sauvegarde();
	
	}
	public Sauvegarde() {
		exp01();
		setTitle("Room Reservation");
		setSize(900, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	 void exp01() {
		 RoomForm ro=new RoomForm();
		 setContentPane(ro); 
	 }
	 void exp02() {
		 
	 }
	
	

}
