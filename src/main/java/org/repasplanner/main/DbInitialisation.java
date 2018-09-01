/**
 * 
 */
package org.repasplanner.main;

import java.util.List;

import org.repasplanner.dao.IngredientRepository;
import org.repasplanner.dao.RecetteRepository;
import org.repasplanner.dao.init.TableCreationDao;
import org.repasplanner.dao.init.TableDataDao;
import org.repasplanner.model.Ingredient;
import org.repasplanner.model.Recette;

/**
 * @author Ameni
 *
 */
public class DbInitialisation {
	/**
	 * @param args
	 *  the command line arguments
	 */
	public static void main(String[] args) {
		TableCreationDao.dropAllTables();
		TableCreationDao.createAllTables();
		TableDataDao.initTables();
		RecetteRepository recRepository = RecetteRepository.getInstance();
		List<Recette> listeRecettes = recRepository.findAll();
		IngredientRepository ingRepository = IngredientRepository.getInstance();
		List<Ingredient> listeIngredient = ingRepository.findIngredientByIdRecette(1); 
	}
}
