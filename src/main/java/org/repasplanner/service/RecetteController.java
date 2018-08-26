package org.repasplanner.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.repasplanner.dao.IngredientRepository;
import org.repasplanner.dao.RecetteRepository;
import org.repasplanner.model.Ingredient;
import org.repasplanner.model.Recette;

public class RecetteController {

	private RecetteRepository recetteRepository =  RecetteRepository.getInstance();
	private IngredientRepository ingredientRepository =  IngredientRepository.getInstance();

	// creation du web service et methode a lancer
	public List<Recette> findAllRecette() {
		List<Recette> listeRecette = recetteRepository.findAll();
		for (Recette r : listeRecette) {
			List<Ingredient> ingredients = ingredientRepository.findIngredientByIdRecette(r.getId());
			r.setIngredients(ingredients);
		}
		return listeRecette;
	}

	public List<Ingredient> createListeCourses(HashMap<String, Integer> mapRecettePersonne) {
		List<Ingredient> listeIngredientAll = new ArrayList<Ingredient>();
		for (Map.Entry<String, Integer> entry : mapRecettePersonne.entrySet()) {
			Recette recette = recetteRepository.getRecetteByNom(entry.getKey()).get(0);
			List<Ingredient> listeIngredientByRecette = getIngredientByRecette(recette, entry.getValue());
			for (Ingredient i : listeIngredientByRecette) {
				listeIngredientAll.add(i);
			}
		}
		return listeIngredientAll;
	}

	private List<Ingredient> getIngredientByRecette(Recette recette, int nbPersonne) {
		List<Ingredient> listeIngredient = new ArrayList<Ingredient>();
		List<Ingredient> listeIngredientInit = recette.getIngredients();
		int nbPersonneRecette = recette.getNombrePersonne();
		for (Ingredient i : listeIngredientInit) {
			double quantite = i.getQuantite();
			quantite *= (nbPersonne / nbPersonneRecette);
			i.setQuantite(quantite);
			listeIngredient.add(i);
		}
		return listeIngredient;
	}

}
