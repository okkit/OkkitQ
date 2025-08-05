package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import quizlogic.FakeDataDeliverer;

public class QuizPanel extends JPanel{

	FakeDataDeliverer fdd = new FakeDataDeliverer();
	
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
