package org.repasplanner.gui;

import java.util.List;

import org.repasplanner.dao.RecetteRepository;
import org.repasplanner.model.Recette;

public class JourPanelController {

	private static JourPanelController instance = null;

	public static JourPanelController getInstance() {
		if (instance == null) {
			instance = new JourPanelController();
		}
		return instance;
	}

	private JourPanelController() {
	}

	public List<Recette> findAllRecette() {
		//List<Recette> listeRecettes = new ArrayList<>();
		RecetteRepository recRepository = RecetteRepository.getInstance();
		List<Recette> listeRecettes = recRepository.findAll();		
		return listeRecettes;
	}

}
