package quizlogic;

import java.util.ArrayList;

public class Theme extends QObject {

	private String title;
	private String text;

	private ArrayList<Question> questions;

	public void addQuestion(Question q) {

		if (questions == null) {
			questions = new ArrayList<Question>();
		}

		questions.add(q);
	}

	public String toString() {
		
		return getId() + " " + title;
	}
	
	public String getFullInfo() {
		StringBuilder info = new StringBuilder();

		info.append("\nThema with id " + getId() + ":");
		info.append("\n  Title: " + title);
		info.append("\n  Text: " + text);
		info.append("\n\n  Fragen:");
		if (questions != null) {
			for (Question question : questions) {

				info.append("\n\n    Title: " + question.getTitle());
				info.append("\n    Text: " + question.getText());

				info.append("\n\n    Antworten:");
				for (Answer a : question.getAnswers()) {

					info.append("\n      Text: " + a.getText());
					info.append("-> " + (a.isCorrect() ? "richtig" : "falsch"));
				}
			}
		}
		return info.toString();
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
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
