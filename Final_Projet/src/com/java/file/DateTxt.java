package com.java.file;
import com.java.india.Date;
import java.io.FileWriter;
import java.io.IOException;

public class DateTxt {

	private static final String chemin = "Date.txt";
		public void enregistrerDat(Date d) {
			 try (FileWriter writer = new FileWriter(chemin, true)) {
		            writer.write(d.toString() + "\n");
		            System.out.println("Date enregistre avec succes ");
		        } catch (IOException e) {
		            e.printStackTrace();
		            System.err.println("Erreur !!!!!!");
		        }
		
	}

}
