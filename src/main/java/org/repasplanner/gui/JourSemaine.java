package org.repasplanner.gui;

public enum JourSemaine {
	// C'est mieux d'utiliser Boolean.FALSE au lieu de false directement 
	LUNDI("Lundi",Boolean.FALSE),
	MARDI("Mardi",Boolean.FALSE),
	MERCREDI("Mercredi",Boolean.FALSE),
	JEUDI("Jeudi",Boolean.FALSE),
	VENDREDI("Vendredi",Boolean.FALSE),
	SAMEDI("Samedi",Boolean.TRUE),
	DIMANCHE("Dimanche",Boolean.TRUE);

	private String nom;
	private Boolean weekend;
	private JourSemaine(String nom, Boolean weekend){
		this.nom = nom;
		this.weekend = weekend;
	}

	public String getNom(){
		return this.nom;

	}

	public Boolean isWeekend() {
		return weekend;
	}


}
