package gui.swing;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;

import quizlogic.dto.ThemeDTO;

public class ThemeListPanel extends JPanel {

	JList<ThemeDTO> jList;

	ThemeSelectionDelegate delegate;

	public void setDelegate(ThemeSelectionDelegate delegate) {
		this.delegate = delegate;
	}

	public ThemeListPanel(ArrayList<ThemeDTO> listData) {
		super();

		initComponents();
		fillWithData(listData);
	}

	private void fillWithData(ArrayList<ThemeDTO> listData) {
		jList.setModel(createModel(listData));
		jList.addListSelectionListener(e -> listItemWasSelected(e));
		
	}

	void initComponents() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Themen"));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6, 6, 6, 6);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		jList = new JList<ThemeDTO>();
		jList.setFont(new Font("Serif", Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane(jList);

		add(scrollPane, gbc);

	}


	public void refreshListData(ArrayList<ThemeDTO> listData) {
		jList.setModel(createModel(listData));
	}

	private ListModel<ThemeDTO> createModel(ArrayList<ThemeDTO> listData) {
		DefaultListModel<ThemeDTO> model = new DefaultListModel<ThemeDTO>();
		for (ThemeDTO th : listData) {
			model.addElement(th);
		}
		return model;
	}

	// die Methode listItemWasSelected wird doppelt aufgerufen - Bug in swing.
	// Um das zu verhindern work around mithilfe der Instanzvariable adjusting
	boolean adjusting = false;

	private void listItemWasSelected(ListSelectionEvent e) {
		if (adjusting) {
			delegate.receiveSelection(jList.getSelectedValue());
		}
		adjusting = e.getValueIsAdjusting();
	}
}
