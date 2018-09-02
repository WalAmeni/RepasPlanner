package org.repasplanner.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.repasplanner.model.Ingredient;
import org.repasplanner.service.ListeFileWriter;
import org.repasplanner.service.RecetteController;

public class FenetreMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel = new JPanel();
	// List<String> listeRecetteNom= new ArrayList<String>();
	private JPanel containerBoutons = new JPanel();
	private JButton boutonReset = new JButton("Reset");
	private JButton boutonValider = new JButton("Valider");
	private HashMap<String, Integer> mapRecettePersonne = new HashMap<String, Integer>();
	private HashMap<JourSemaine, JourPanel> mapJourPanel = new HashMap<JourSemaine, JourPanel>();

	public FenetreMenu() {

		this.setTitle("Choisissez votre menu de la semaine ");
		this.setSize(600, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		for (JourSemaine jour : JourSemaine.values()) {
			JourPanel jourPanel = new JourPanel(jour);
			mapJourPanel.put(jour, jourPanel);
			mainPanel.add(jourPanel.getContainer());

		}

		containerBoutons.setLayout(new BorderLayout());
		containerBoutons.add(boutonReset, BorderLayout.WEST);
		boutonReset.addActionListener(new ActionReset());
		containerBoutons.add(boutonValider, BorderLayout.EAST);
		boutonValider.addActionListener(new ActionValider());
		mainPanel.add(containerBoutons, "wrap");

		this.setContentPane(mainPanel);
		this.setVisible(true);
	}

	class ActionValider implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			LocalDate localDate = LocalDate.now();
			for (JourSemaine jour : JourSemaine.values()) {
				// System.out.println(jour);
				JourPanel jourPanel = mapJourPanel.get(jour);
				HashMap<String, Integer> mapRecettePersonneJour = jourPanel.getRecettePersonneJour();
				// for (Map.Entry<String, Integer> entry :
				// mapRecettePersonneJour.entrySet()) {
				// System.out.println(entry.getKey() + " " + entry.getValue());
				// }
				for (String c : mapRecettePersonneJour.keySet()) {
					if (mapRecettePersonne.containsKey(c)) {
						int nbPersonne = mapRecettePersonne.get(c);
						nbPersonne += mapRecettePersonneJour.get(c);
						mapRecettePersonne.put(c, nbPersonne);
					} else {
						mapRecettePersonne.put(c, mapRecettePersonneJour.get(c));
					}
				}
			}
			for (Map.Entry<String, Integer> entry : mapRecettePersonne.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
			//liste de course
			//System.out.println("Liste de course");
			List<Ingredient> listeCourse = new RecetteController().createListeCourses(mapRecettePersonne);
			//listeCourse.forEach(i -> System.out.println(i));	           
			ListeFileWriter.writeListeDeCourse(listeCourse);
			JOptionPane.showMessageDialog(null, "La liste de course est créée dans "+"D:\\JAVA\\listeDeCourse"+localDate+".txt");
		}
	}

	class ActionReset implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int dialogResult = JOptionPane.showConfirmDialog(mainPanel, "Voulez vous supprimer vos choix ?", "Warning",
					JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				mapJourPanel.values().stream().forEach(e -> e.cleanPanel());
			}
		}

	}

	public HashMap<String, Integer> getMapRecettePersonne() {
		return mapRecettePersonne;
	}

}