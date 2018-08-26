package org.repasplanner.gui;

import java.util.List;

import org.repasplanner.model.Recette;

import com.google.common.collect.Lists;

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
		return Lists.newArrayList();
	}

}
