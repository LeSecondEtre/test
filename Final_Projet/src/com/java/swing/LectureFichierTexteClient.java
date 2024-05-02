package com.java.swing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectureFichierTexteClient {
	
	public LectureFichierTexteClient() {
	
        String cheminFichier = "client_data.txt";

        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;

            // Lecture ligne par ligne
            while ((ligne = lecteur.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    
}