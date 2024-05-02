package com.java.swing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectureChambre {
	
	 public LectureChambre() {
	        String cheminFichier = "room.txt";

	        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
	            String ligne;

	            // Lecture ligne par ligne
	            while ((ligne = lecteur.readLine()) != null) {
	                // Exemple : Extraire les sous-chaînes des 5 premiers caractères
	                if (ligne.length() >= 11) {
	                    String sousChaine = ligne.substring(0, 11);
	                    System.out.println(sousChaine+" est reservée");
	                } else {
	                    // Si la ligne est plus courte que 5 caractères
	                    System.out.println("Ligne trop courte");
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	

}
