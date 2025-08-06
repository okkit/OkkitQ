package gui.okkit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThemeButtonsPanel extends JPanel {

	JButton btnLoeschen;
	JButton btnSpeichern;
	JButton btnNeuesThema;
	JTextField messageArea;

	ThemeActionDelegate delegate;

	public void setDelegate(ThemeActionDelegate delegate) {
		this.delegate = delegate;
	}

	public ThemeButtonsPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(7, 7, 7, 7);

		// Message-Area
		messageArea = new JTextField();
		messageArea.setEditable(false);
		messageArea.setText("Message area");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		add(messageArea, gbc);

		// Buttons
		btnLoeschen = new JButton("Thema Löschen");
		btnLoeschen.addActionListener(e -> delegate.deleteTheme());
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(e -> delegate.saveTheme());
		btnNeuesThema = new JButton("Neues Thema");
		btnNeuesThema.addActionListener(e -> delegate.newTheme());

		gbc.gridwidth = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0.0;

		gbc.gridx = 0;
		add(btnLoeschen, gbc);

		gbc.gridx = 1;
		add(btnSpeichern, gbc);

		gbc.gridx = 2;
		add(btnNeuesThema, gbc);
	}
	
	void showMessage(String msg) {
		messageArea.setText(msg);
	}
}
