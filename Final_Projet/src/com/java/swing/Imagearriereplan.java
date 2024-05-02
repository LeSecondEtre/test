package com.java.swing;
import java.awt.Image;
import java.io.File;
import java.awt.Graphics;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;

public class Imagearriereplan extends JFrame{

	 public Imagearriereplan() {

	        ImageIcon imageIcon = new ImageIcon("P.jpeg"); 
	        JLabel labelImage = new JLabel(imageIcon);
	        this.setSize(500,500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight()); 
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());
	        setOpacity(1);
	        add(labelImage);
	        setVisible(true);
	        
	    }
	
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new Imagearriereplan();
	        });
	    }
}




	

