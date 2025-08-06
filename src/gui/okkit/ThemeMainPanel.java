package gui.okkit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import persistence.QuizDataInterface;
import persistence.serialization.QuizDataManager;
import quizlogic.Theme;

/**
 * 
 */
public class ThemeMainPanel extends JPanel implements ThemeActionDelegate, ThemeSelectionDelegate {

	ThemeListPanel panelThemenList;
	ThemeEditPanel panelThemeEdit;
	ThemeButtonsPanel panelActions;

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
		panelThemenList = new ThemeListPanel(manager.getAllThemes());
		System.out.println(manager.getAllThemes());
		panelThemenList.setDelegate(this);

		panelThemeEdit = new ThemeEditPanel();

		panelActions = new ThemeButtonsPanel();
		panelActions.setDelegate(this);
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
		add(panelThemeEdit, gbc);

		// Rechtes Panel
		gbc.gridx = 1;
		gbc.insets = new Insets(15, 5, 0, 10);
		add(panelThemenList, gbc);

		// Unteres Panel
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(5, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(panelActions, gbc);
	}

	void refreschPanelsWith(String msg, Theme th, boolean refreshListData) {
		panelActions.showMessage(msg);
		panelThemeEdit.setThemeToEdit(th);
		if (refreshListData)
			panelThemenList.refreshListData(manager.getAllThemes());
	}

	@Override
	public void saveTheme() {
		Theme theme = panelThemeEdit.getEditedTheme();
		System.out.println("saveTheme " + theme.getId() + " " + theme.getText());
		String msg = manager.saveTheme(theme);
		System.out.println("saved " + theme.getId() + " " + theme.getText());
		refreschPanelsWith(msg, theme, true);

	}

	@Override
	public void deleteTheme() {
		String msg = manager.deleteTheme(panelThemeEdit.getEditedTheme());
		refreschPanelsWith(msg, null, true);
	}

	@Override
	public void newTheme() {
		refreschPanelsWith(null, null, true);

	}

	@Override
	public void receiveSelection(Theme theme) {
		panelActions.showMessage(null);
		panelThemeEdit.setThemeToEdit(theme);

	}
}
