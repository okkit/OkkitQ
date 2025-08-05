package gui.prototyp;

import java.awt.GridLayout;

import javax.swing.JPanel;

import persistence.serialization.QuizDataManager;

/**
 * 
 */
public class QuizPanel extends JPanel{

	/**
	 * 
	 */
	QuizDataManager fdd = new QuizDataManager();
	
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
