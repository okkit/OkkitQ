package gui.okkit;

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

import quizlogic.Theme;

public class ThemeListPanel extends JPanel {
	
	ThemeSelectionDelegate delegate;
    JList<Theme> jList;
    
	public ThemeListPanel(ArrayList<Theme> listData) {
		super();
		initList(listData);
	
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Themen"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1.0; gbc.weighty = 1.0;

//        String[] themen = {
//                "Titel des Themas 1", "Titel des Themas 2", "Titel des Themas 3",
//                "Titel des Themas 4", "Titel des Themas 5", "Titel des Themas 6",
//                "Titel des Themas 7", "Titel des Themas 8", "Titel des Themas 9",
//                "Titel des Themas 10"
//        };

        jList = new JList<Theme>();
        jList.setFont(new Font("Serif", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(jList);

        add(scrollPane, gbc);
    }
    

	private void initList(ArrayList<Theme> listData) {

		jList = new JList<Theme>(createModel(listData));
		jList.addListSelectionListener(e -> listItemWasSelected(e));
		
		JScrollPane pane = new JScrollPane(jList);
		add(pane);
	}
	
	public void refreshListData(ArrayList<Theme> listData) {

		jList.setModel(createModel(listData));
	}

	private ListModel<Theme> createModel(ArrayList<Theme> listData) {
		DefaultListModel<Theme> model = new DefaultListModel<Theme>();
		for (Theme object : listData) {
			model.addElement(object);
		}
		return model;
	}

	// die Methode listItemWasSelected wird doppelt aufgerufen - Bug in swing.
	// Um das zu verhindern work around mithilfe der Instanzvariable adjusting
	boolean adjusting = false;

	private void listItemWasSelected(ListSelectionEvent e) {
		if (adjusting)
			delegate.receiveSelection(jList.getSelectedValuesList().get(0));
		adjusting = e.getValueIsAdjusting();
	}
}

