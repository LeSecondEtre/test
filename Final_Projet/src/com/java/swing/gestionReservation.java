package com.java.swing;

import com.java.india.Hotel;

public class gestionReservation {
	private static int cp1=0;
	private static int cp2=0;
	
	public boolean  verifierdisponibilitéS() {
		if (cp1<Hotel.NCS) {
			return true;
		}
		else {
			return false;
		}
	}
		public  static int  getincrementerCpS() {
			return cp1++;
			
		}
		public boolean  verifierdisponibilitéD() {
			if (cp2<Hotel.NCD) {
				return true;
			}
			else {
				return false;
			}
		}
			public  static int  getincrementerCpD() {
				return cp2++;
				
			}
		
		
	}


