package gui.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import quizlogic.AppManager;
import quizlogic.FakeManager;
import quizlogic.Initialisation;
import quizlogic.OkkitQConstants;
import quizlogic.dto.ThemeDTO;

/**
 * Das Hauptpanel für die Themenverwaltung in der Nutzeroberfläche.
 * <p>
 * Dieses Panel kombiniert eine Themenliste, ein Bearbeitungspanel sowie
 * Steuerungsbuttons. Es übernimmt zudem die Steuerung der Haupt-CRUD-Aktionen
 * (Create, Read, Update, Delete) für {@link ThemeDTO}-Objekte über Delegation.
 * </p>
 * 
 * The main panel for theme management in the application's graphical user
 * interface.
 * <p>
 * This panel combines a theme list, an editing panel, and control buttons. It
 * manages the main CRUD (Create, Read, Update, Delete) operations for
 * {@link ThemeDTO} objects via delegation.
 * </p>
 *
 * <ul>
 * <li>Left panel: {@link ThemeEditPanel} for editing a theme</li>
 * <li>Right panel: {@link ThemeListPanel} displaying all themes</li>
 * <li>Bottom panel: {@link ThemeButtonsPanel} containing action buttons
 * (create, save, delete)</li>
 * </ul>
 *
 * 
 * @author ValentinaTikko
 */

public class ThemeMainPanel extends JPanel implements ThemeActionDelegate, ThemeSelectionDelegate {

	/** Panel with the theme list. */
	ThemeListPanel panelThemenList;

	/** Panel for editing a theme. */
	ThemeEditPanel panelThemeEdit;

	/** Panel with control buttons. */
	ThemeButtonsPanel panelActions;

	/**
	 * Data manager for quiz themes. Manages the data transport from the persistence
	 * layer and backwards
	 */
	AppManager manager;

	/**
	 * Erzeugt ein neues {@code ThemeMainPanel} und initialisiert sämtliche
	 * Unterpanels. Constructs a new {@code ThemeMainPanel} and initializes all
	 * sub-panels.
	 */
	public ThemeMainPanel() {
		super();
		manager = Initialisation.getClassForAppManager(OkkitQConstants.INI_FILE_FOR_APP_MANAGER);
		if (manager == null) {
			manager = new FakeManager();
		}
		initPanels();
		addPanels();

	}

	/**
	 * Initializes the sub-panels and assigns necessary delegates.
	 */
	void initPanels() {
		panelThemenList = new ThemeListPanel(manager.getThemes());
		panelThemenList.setDelegate(this);

		panelThemeEdit = new ThemeEditPanel();

		panelActions = new ThemeButtonsPanel();
		panelActions.setDelegate(this);
	}

	/**
	 * Adds the panels to the main panel and arranges them using GridBagLayout.
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

	/**
	 * Updates the sub-panels with changed data; displays a status message and sets
	 * the theme to edit when needed.<br>
	 * Aktualisiert die Unterpanels anhand geänderter Daten, zeigt eine
	 * Statusmeldung und setzt ggf. das zu bearbeitende Thema.
	 *
	 * @param msg             Message to display (e.g., success/error)
	 * @param th              The theme to display in the edit panel (may be null)
	 * @param refreshListData {@code true} if the theme list should be reloaded,
	 *                        otherwise {@code false}
	 */
	void refreschPanelsWith(String msg, ThemeDTO th, boolean refreshListData) {
		panelActions.showMessage(msg);
		panelThemeEdit.setThemeToEdit(th);
		if (refreshListData)
			panelThemenList.refreshListData(manager.getThemes());
	}

	/**
	 * Called when a theme is to be saved. Retrieves the currently edited theme,
	 * saves it using the manager, and updates the UI.<br>
	 * Wird aufgerufen, wenn ein Thema gespeichert werden soll. Holt das aktuell
	 * editierte Thema, speichert es im Manager und aktualisiert die Oberfläche.
	 * 
	 */
	@Override
	public void saveTheme() {
		ThemeDTO theme = panelThemeEdit.getEditedTheme();

		if (theme.getTitle() == null || theme.getTitle().trim().isEmpty()) {
			JOptionPane.showConfirmDialog(this, "Geben Sie mindestens den Titel an", "",
					JOptionPane.CANCEL_OPTION);
			return;
		}

		if (theme.getText() == null || theme.getText().trim().isEmpty()) {
			int ja = JOptionPane.showConfirmDialog(this,
					"Möchten Sie wirklich nur den Titel speichern?", "",
					JOptionPane.OK_CANCEL_OPTION);
			System.out.println(ja);
			if (ja != 0) {
				return;
			}
		}
		String msg = manager.saveTheme(theme);
		panelActions.showMessage(msg);

	}

	/**
	 * Called when a theme is to be deleted. Deletes the currently edited theme and
	 * updates the UI.<br>
	 * Wird aufgerufen, wenn ein Thema gelöscht werden soll. Löscht das aktuell
	 * editierte Thema im Manager und aktualisiert die Oberfläche.
	 */
	@Override
	public void deleteTheme() {
		String msg = manager.deleteTheme(panelThemeEdit.getEditedTheme());
		refreschPanelsWith(msg, null, true);
	}

	/**
	 * Wird aufgerufen, wenn ein neues Thema angelegt werden soll. Setzt die
	 * Oberfläche auf einen leeren Zustand.
	 */
	@Override
	public void newTheme() {
		refreschPanelsWith(null, null, true);

	}

	/**
	 * Wird aufgerufen, wenn ein Thema aus der Liste ausgewählt wurde. Übergibt das
	 * ausgewählte Thema an das Bearbeitungspanel.
	 *
	 * @param theme Das vom Nutzer ausgewählte {@link ThemeDTO}
	 */
	@Override
	public void receiveSelection(ThemeDTO theme) {
		panelActions.showMessage(null);
		panelThemeEdit.setThemeToEdit(theme);

	}
}
