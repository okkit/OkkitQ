/**
 * @Perplexity
 * @André Lenders
 * @author ValentinaTikko
 */
package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gui.layout.QPanel;
import quizlogic.Answer;
import quizlogic.FakeDataDeliverer;
import quizlogic.Question;

public class QuestionPanel extends QPanel implements ListSelectionDelegate {

	private JLabel themaTextLabel;
	private JTextField titleTextField;
	private JTextArea questionArea;
	private ArrayList<JTextField> anwersFields;

	private ArrayList<JCheckBox> correctBoxes;
	private JTextArea msgArea;

	int answersCount = 4;

	FakeDataDeliverer fdd = new FakeDataDeliverer();

	public QuestionPanel() {
		super();

		initComponents();
		addComponents();
		fillWithData(null);
	}

	private void fillWithData(Question q) {
		if (q != null) {
			
			themaTextLabel.setText(q.getThema().getTitle());
			titleTextField.setText(q.getTitle());
			questionArea.setText(q.getText());

			ArrayList<Answer> answers = q.getAnswers();
			Answer a;
			for (int i = 0; i < answers.size(); i++) {
				a = answers.get(i);
				anwersFields.get(i).setText(a.getText());
				correctBoxes.get(i).setSelected(a.isCorrect());
			}
		}
	}
	
	@Override
	public void receiveSelection(Question q) {
		fillWithData(q);
		
	}

	void initComponents() {

		themaTextLabel = new JLabel();
		titleTextField = new JTextField();
		questionArea = new JTextArea(40, 200);

		anwersFields = new ArrayList<JTextField>(answersCount);
		correctBoxes = new ArrayList<JCheckBox>(answersCount);

		for (int i = 0; i < answersCount; i++) {
			anwersFields.add(new JTextField(18));
			correctBoxes.add(new JCheckBox());
		}

		msgArea = new JTextArea();
	}

	void addComponents() {
		int row = 0;
		// 1. Thema
		gbc.anchor = GridBagConstraints.SOUTH;
		addComponent(new JLabel("Thema"), row, 0);
		themaTextLabel.setMinimumSize(new Dimension(200, 22));
		addComponent(themaTextLabel, row, 1);
		addBoxOrEmpty(2, row);
		row++;

		// 2. Titel
		addComponent(new JLabel("Titel"), row, 0);
		addComponent(titleTextField, row, 1);
		addBoxOrEmpty(2, row);
		row++;

		// 3. Frage
		addComponent(new JLabel("Frage"), row, 0);

		JScrollPane pane = new JScrollPane(questionArea);
		pane.setMinimumSize(new Dimension(200, 100));
		addComponent(pane, row, 1);
		addBoxOrEmpty(2, row);
		row++;

		// 4. Antwortwahl
		addComponent(new JLabel("Antwortwahl"), row, 0);
		addBoxOrEmpty(1, row);
		addComponent(new JLabel("Richtig"), row, 2);
		row++;

		// 5-8. Antwort 1-4
		for (int i = 0; i < anwersFields.size(); i++) {
			addComponent(new JLabel("Antwort " + i), row, 0);
			addComponent(anwersFields.get(i), row, 1);
			addComponent(correctBoxes.get(i), row, 2);
			row++;
		}

		// 9. Meldungen
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		addComponent(msgArea, row, 0);

	}
}
