package org.repasplanner.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.repasplanner.dao.IngredientRepository;
import org.repasplanner.dao.RecetteRepository;
import org.repasplanner.model.Ingredient;
import org.repasplanner.model.Recette;

public class RecetteController {

	private RecetteRepository recetteRepository =  RecetteRepository.getInstance();
	private IngredientRepository ingredientRepository =  IngredientRepository.getInstance();

	//	// creation du web service et methode a lancer
	//	public List<Recette> findAllRecette() {
	//		List<Recette> listeRecette = recetteRepository.findAll();
	//		for (Recette r : listeRecette) {
	//			List<Ingredient> ingredients = ingredientRepository.findIngredientByIdRecette(r.getId());
	//			r.setIngredients(ingredients);
	//		}
	//		return listeRecette;
	//	}

	public List<Ingredient> createListeCourses(HashMap<String, Integer> mapRecettePersonne) {
		List<Ingredient> listeIngredientAll = new ArrayList<Ingredient>();
		for (Map.Entry<String, Integer> entry : mapRecettePersonne.entrySet()){

			System.out.println(entry.getKey()+ " "+entry.getValue());
			Recette recette = recetteRepository.getRecetteByNom(entry.getKey());
			//System.out.println(recette.getNom());
			List<Ingredient> listeIngredientByRecette = getIngredientByRecette(recette, entry.getValue());

			for (Ingredient i : listeIngredientByRecette) {
				//System.out.println(i.sameNameUnit(ingredientTest));
				//regrouper les ingredients qui ont les meme noms et les memes unite
				if(!listeIngredientAll.isEmpty()){
					//					listeIngredientAll.forEach(c -> System.out.println(c));
					Optional<Ingredient> opt = listeIngredientAll.stream().filter(c -> IngredientController.sameNameUnit(c,i)).findAny();				
					if(opt.isPresent()){
						listeIngredientAll.remove(opt.get());
						Ingredient newIngredient = IngredientController.concat(i,opt.get());
						listeIngredientAll.add(newIngredient);
					}else{
						listeIngredientAll.add(i);	
					}
				}else{
					listeIngredientAll.add(i);	
				}

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
			//System.out.println(i.getNom());
			//System.out.println("quantite initiale"+ quantite);
			quantite = (quantite * nbPersonne) / nbPersonneRecette;
			//System.out.println("quantite finale"+ quantite);
			i.setQuantite(quantite);
			listeIngredient.add(i);
		}
		return listeIngredient;
	}

}
