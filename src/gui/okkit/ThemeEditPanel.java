package gui.okkit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ThemeEditPanel extends JPanel {
	JTextField titelFeld;
	JTextArea infoArea;

	public ThemeEditPanel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Neues Thema"));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6, 6, 6, 6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;

		// Titel
		add(new JLabel("Titel"), gbc);

		titelFeld = new JTextField(18);
		gbc.gridx = 1;
		add(titelFeld, gbc);

		// Information zum Thema
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(14, 6, 6, 6);
		add(new JLabel("Information zum Thema"), gbc);

		infoArea = new JTextArea(7, 22);
		JScrollPane infoScroll = new JScrollPane(infoArea);
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(infoScroll, gbc);
	}
}
