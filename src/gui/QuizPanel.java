package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class QuizPanel extends JPanel{

	public QuizPanel() {
		super();
		
		setLayout(new GridLayout(1, 2));
		QuestionPanel qp = new QuestionPanel();
		add(qp);
		QuestionListPanel lp = new QuestionListPanel();
		lp.delegate = qp;
		add(lp);
	}
	
	

}
