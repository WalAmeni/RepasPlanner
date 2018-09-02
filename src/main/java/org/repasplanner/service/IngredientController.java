package org.repasplanner.service;

import java.util.List;

import org.repasplanner.dao.IngredientRepository;
import org.repasplanner.model.Ingredient;

public class IngredientController {

	public static boolean sameNameUnit(Ingredient ingredient1, Ingredient ingredient2){
		return (ingredient1.getNom().equalsIgnoreCase(ingredient2.getNom()) && ingredient1.getUnite().equalsIgnoreCase(ingredient2.getUnite()));
	}
	
	public static Ingredient concat(Ingredient ingredient1, Ingredient ingredient2) {
		Ingredient newIngredient = new Ingredient();
		newIngredient.setNom(ingredient1.getNom());
		newIngredient.setType(ingredient1.getType());
		newIngredient.setUnite(ingredient1.getUnite());
		newIngredient.setQuantite(ingredient1.getQuantite()+ ingredient2.getQuantite());
		return newIngredient;
	}
	
}
