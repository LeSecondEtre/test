package com.java.file;

import java.io.FileWriter;
import java.io.IOException;

import com.java.india.Client;

public class FileTxt {
	//chemin ou on va enregistrer le fichier texte+nom du fichier txt
	private static final String chemin = "client_data.txt";

    

	public void enregistrerCli(Client cli) {
		 try (FileWriter writer = new FileWriter(chemin, true)) {//ouverture
	            // Écrire les données du client dans le fichier texte
	            writer.write(cli.toString() + "\n");
	            System.out.println("Client enregistre avec succes :)");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.err.println("Erreur d enregistrement!");
	        }
		
	}

}