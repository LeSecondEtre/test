package com.java.swing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectureRoom {

	public LectureRoom() {
		
        String cheminFichier = "room.txt";

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
