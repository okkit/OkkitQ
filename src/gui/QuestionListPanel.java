package gui;

import javax.swing.JButton;
import javax.swing.JLabel;

import gui.layout.QPanel;
import persistence.serialization.QuizDataManager;

public class QuestionListPanel extends QPanel{
	
	ListSelectionDelegate delegate;
	
	public QuestionListPanel() {
		super();
		add(new JLabel("Panel, auf dem die Liste ist"));
		
		JButton b = new JButton("Test");
		b.addActionListener(e -> questionWasSelected());
		add(b);
	}

	private void questionWasSelected() {
		
		delegate.receiveSelection((new QuizDataManager()).getRandomQuestion());
	}
	
	

}
