package gui.okkit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import persistence.QuizDataInterface;
import persistence.serialization.QuizDataManager;

/**
 * 
 */
public class ThemeMainPanel extends JPanel implements ThemeActionDelegate, ThemeSelectionDelegate{


	ThemeListPanel panelThemenListe; 
	ThemeEditPanel panelNeuesThema;
	ThemeButtonsPanel panelAktionen;
	
	QuizDataInterface manager = new QuizDataManager();

	/**
	 * Konstruktor.
	 */
	public ThemeMainPanel() {
		super();
		initPanels();
		addPanels();
	}

	/**
	 * Initialisiert die Felder (also die Panels)
	 */
	void initPanels() {
		 panelThemenListe = new ThemeListPanel(manager.getAllThemes());
		 
		 panelNeuesThema = new ThemeEditPanel();
		 panelAktionen = new ThemeButtonsPanel();
	}

	/**
	 * Fühgt die Panels hinzu (addet) inkl. Layout
	 */
	void addPanels() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Linkes Panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(15, 10, 0, 5);
		gbc.fill = GridBagConstraints.BOTH;
		add(panelNeuesThema, gbc);

		// Rechtes Panel
		gbc.gridx = 1;
		gbc.insets = new Insets(15, 5, 0, 10);
		add(panelThemenListe, gbc);

		// Unteres Panel
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(5, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(panelAktionen, gbc);
	}


	@Override
	public void saveTheme() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTheme() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newTheme() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveSelection(Object th) {
		// TODO Auto-generated method stub
		
	}
}
