package com.java.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.java.india.Room;

public class RommFileText {
	
	private static final String chemin ="room.txt";
	
	public static void ecriredansFichier(Room r) {
	    try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(chemin, true)))) {
	        writer.println(r.toString());
	        System.out.println("Chambre enregistrée");
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Erreur d'enregistrement : " + e.getMessage());
	    }
	}

	public  void lireFichier(String chemin1) {
        try (Scanner scanner = new Scanner(new File(chemin1))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Traitement de chaque ligne lue (dans votre cas, peut-être créer des objets Room à partir de ces lignes)
                System.out.println("Ligne lue : " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fichier non trouvé : " + e.getMessage());
        }
    }
	
}


