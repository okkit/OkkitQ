package gui.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import quizlogic.dto.ThemeDTO;

public class ThemeEditPanel extends JPanel {

	JLabel titleLabel;
	JTextField titelFeld;
	JLabel infoLabel;
	JTextArea infoArea;

	ThemeDTO theme;

	public ThemeEditPanel() {

		super();
		initComponents();
		addComponents();
	}

	ThemeDTO getEditedTheme() {

		if (theme == null) {
			theme = new ThemeDTO();
		}
		theme.setTitle(titelFeld.getText());
		theme.setText(infoArea.getText());
		return theme;
	}

	void setThemeToEdit(ThemeDTO theme) {
		this.theme = theme;
		String borderTitle = theme == null ? "Neues Thema" : "Thema " + theme.getId();
		setBorder(BorderFactory.createTitledBorder(borderTitle));
		titelFeld.setText(theme == null ? null : theme.getTitle());
		infoArea.setText(theme == null ? null : theme.getText());

	}

	private void initComponents() {
		titleLabel = new JLabel("Titel");
		titelFeld = new JTextField(18);

		infoLabel = new JLabel("Information zum Thema");
		infoArea = new JTextArea(7, 22);
	}

	private void addComponents() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Neues Thema"));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(6, 6, 6, 6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;

		// Titel
		add(titleLabel, gbc);
		gbc.gridx = 1;
		add(titelFeld, gbc);

		// Information zum Thema
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(14, 6, 6, 6);
		add(infoLabel, gbc);

		JScrollPane infoScroll = new JScrollPane(infoArea);
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(infoScroll, gbc);
	}

}
