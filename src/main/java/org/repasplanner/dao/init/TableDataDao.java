/**
 * 
 */
package org.repasplanner.dao.init;

import org.repasplanner.dao.IngredientRepository;
import org.repasplanner.dao.RecetteRepository;
import org.repasplanner.model.TypeIngredient;

/**
 * @author Ameni
 *
 */
public class TableDataDao {

	private TableDataDao() {
	}
	public static void initTables(){
		RecetteRepository recRepository = RecetteRepository.getInstance();
		IngredientRepository ingRepository = IngredientRepository.getInstance();
		
		//		-- Recette 1
		recRepository.insert("Pates bolognaise", "40 min","To do", 4);
		
        //		--- Ingredient Recette 1	
		ingRepository.insert("pates", TypeIngredient.EPICERIE_SALEE, 500, "g", 1);
		ingRepository.insert("viande_hachee", TypeIngredient.PROTEINE, 500, "g", 1);
		ingRepository.insert("sauce_tomate", TypeIngredient.EPICERIE_SALEE, 1, "boite", 1);
		ingRepository.insert("oignon", TypeIngredient.LEGUME, 2, "piece", 1);
		ingRepository.insert("ail", TypeIngredient.LEGUME, 1, "piece", 1);
		ingRepository.insert("huile_olive", TypeIngredient.EPICERIE_SALEE, 4, "cas", 1);
		
//		-- Recette 2
		recRepository.insert("Poulet/legume", "40 min","To do", 4);
		
        //		--- Ingredient Recette 2
		ingRepository.insert("pain", TypeIngredient.BOULANGERIE,1 , "piece", 2);
		ingRepository.insert("cuisse_poulet", TypeIngredient.PROTEINE, 4, "piece", 2);
		ingRepository.insert("sauce_tomate", TypeIngredient.EPICERIE_SALEE, 1, "cas", 2);
		ingRepository.insert("oignon", TypeIngredient.LEGUME, 2, "piece", 2);
		ingRepository.insert("ail", TypeIngredient.LEGUME, 1, "piece", 2);
		ingRepository.insert("pomme de terre", TypeIngredient.LEGUME, 4, "piece", 2);
		ingRepository.insert("piment", TypeIngredient.LEGUME, 2, "piece", 2);
		ingRepository.insert("poivron rouge", TypeIngredient.LEGUME, 0.5, "piece", 2);
		ingRepository.insert("tomate",TypeIngredient.LEGUME, 2, "piece", 2);
		ingRepository.insert("huile_olive", TypeIngredient.EPICERIE_SALEE, 8, "cas", 2);

	}
}

