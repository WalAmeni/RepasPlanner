package org.repasplanner.gui;

import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.repasplanner.model.Recette;


public class JourPanel {
	private JourSemaine jour;
	private JPanel container = new JPanel();
	private JLabel labelDejeuner= new JLabel("Déjeuner");
	private JLabel labelDiner= new JLabel("Diner");
	private JLabel labelPersonneDej= new JLabel("personnes");
	private JLabel labelPersonneDiner= new JLabel("personnes");
	private HashMap<String,Integer> mapRecettePersonneJour = new HashMap<String,Integer>();


	private JComboBox<String> comboRecetteDej  ;
	private JComboBox<String> comboRecetteDiner ;

	private JFormattedTextField nombrePersonneDej = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JFormattedTextField nombrePersonneDiner= new JFormattedTextField(NumberFormat.getIntegerInstance());

	public JourPanel(JourSemaine jour){
		this.jour= jour;
		buildPanel();

	}
	private void buildPanel(){		
		GridLayout g = new GridLayout(2, 4);
		container.setLayout(g);
		g.setHgap(10);
		g.setVgap(5);
		container.add(labelDejeuner);
		List<Recette> rec = JourPanelController.getInstance().findAllRecette();
		ArrayList<String> tabRecette = new ArrayList<String>();
		tabRecette.add("--Recettes--");
		rec.forEach(r -> tabRecette.add(r.getNom()));
		String[] array = tabRecette.toArray(new String[tabRecette.size()]);
		comboRecetteDej = new JComboBox<>(array);
		comboRecetteDiner = new JComboBox<>(array);
		container.add(comboRecetteDej);		
		container.add(nombrePersonneDej);
		container.add(labelPersonneDej);
		container.add(labelDiner);
		container.add(comboRecetteDiner);
		container.add(nombrePersonneDiner);
		container.add(labelPersonneDiner);
		TitledBorder title = BorderFactory.createTitledBorder(jour.getNom());
		container.setBorder(title);


	}
	public JPanel getContainer() {
		return container;
	}
	public String getRecetteDej(){
		return comboRecetteDej.getSelectedItem().toString();
	}
	public String getRecetteDiner(){
		return comboRecetteDiner.getSelectedItem().toString();
	}
	public int getPersonneDejNombre(){
		try{
			return Integer.parseInt(nombrePersonneDej.getText());
		}catch (java.lang.NumberFormatException e){
			return 0;
		}
	}
	public int getPersonneDinerNombre(){
		try{
			return Integer.parseInt(nombrePersonneDiner.getText());
		}catch (java.lang.NumberFormatException e){
			return 0;
		}

	}

	public HashMap<String,Integer> getRecettePersonneJour(JourPanel this) {
		if (this.getRecetteDej()!= "--Recettes--"){
			if (mapRecettePersonneJour.containsKey(this.getRecetteDej())){
				int nbPersonne= mapRecettePersonneJour.get(this.getRecetteDej());
				nbPersonne += this.getPersonneDejNombre();
				mapRecettePersonneJour.put(this.getRecetteDej(), nbPersonne);
			}else{
				mapRecettePersonneJour.put(this.getRecetteDej(),this.getPersonneDejNombre());
			}
		}
		if (this.getRecetteDiner()!= "--Recettes--"){
			if (mapRecettePersonneJour.containsKey(this.getRecetteDiner())){
				int nbPersonne= mapRecettePersonneJour.get(this.getRecetteDiner());
				nbPersonne += this.getPersonneDinerNombre();
				mapRecettePersonneJour.put(this.getRecetteDiner(), nbPersonne);
			}else{
				mapRecettePersonneJour.put(this.getRecetteDiner(),this.getPersonneDinerNombre());
			}
		}
		return mapRecettePersonneJour;
	}
	public void cleanPanel(){
		this.comboRecetteDej.setSelectedIndex(0);
		this.comboRecetteDiner.setSelectedIndex(0);
		this.nombrePersonneDej.setText("");
		this.nombrePersonneDiner.setText("");
	}

}

