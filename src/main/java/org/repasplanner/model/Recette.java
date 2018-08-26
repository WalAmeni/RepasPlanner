package org.repasplanner.model;

import java.util.List;

public class Recette {
private String nom;
private List<Ingredient> ingredients;
private String tempsPreparation;
private String description;
private int nombrePersonne;
private int id;

public Recette() {
	super();
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public List<Ingredient> getIngredients() {
	return ingredients;
}

public void setIngredients(List<Ingredient> ingredients) {
	this.ingredients = ingredients;
}

public String getTempsPreparation() {
	return tempsPreparation;
}

public void setTempsPreparation(String tempsPreparation) {
	this.tempsPreparation = tempsPreparation;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getNombrePersonne() {
	return nombrePersonne;
}

public void setNombrePersonne(int nombrePersonne) {
	this.nombrePersonne = nombrePersonne;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


}
