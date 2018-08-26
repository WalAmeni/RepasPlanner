package org.repasplanner.service;

import java.util.List;

import org.repasplanner.dao.IngredientRepository;
import org.repasplanner.model.Ingredient;

public class IngredientController {

	
	public List<Ingredient> getIngredientByRecetteId(int idRecette){
		return IngredientRepository.getInstance().findIngredientByIdRecette(idRecette);
	}
	
}
