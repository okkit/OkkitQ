package quizlogic;

import java.util.ArrayList;

public class Question extends QObject {

	private String title;
	private String text;

	private Theme thema;
	private ArrayList<Answer> answers;

	public Question(Theme thema) {
		super();
		this.thema = thema;
	}
	
	
	public ArrayList<Answer> getAnswers() {
		return answers;
	}


	public void addAnswer(Answer a) {
		
		if (answers == null) {
			answers = new ArrayList<Answer>();
		}
		answers.add(a);
	}

	public Theme getThema() {
		return thema;
	}

	public void setThema(Theme thema) {
		this.thema = thema;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
