package org.repasplanner.model;

import java.util.Optional;

public class Ingredient {
	private String nom;
	private TypeIngredient type;
	private double quantite;
	private String unite;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeIngredient getType() {
		return type;
	}

	public void setType(TypeIngredient type) {
		this.type = type;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}
	

	@Override
	public String toString() {
		return "Ingredient [nom=" + nom + ", type=" + type + ", quantite=" + quantite + ", unite=" + unite + "]";
	}



}
