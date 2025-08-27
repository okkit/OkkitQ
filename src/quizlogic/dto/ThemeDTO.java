package quizlogic.dto;

import java.util.ArrayList;

import quizlogic.DataTransportObject;

public class ThemeDTO extends DataTransportObject implements Comparable<ThemeDTO>{

	private String title;
	private String text;

	private ArrayList<QuestionDTO> questions;

	public void addQuestion(QuestionDTO q) {

		if (questions == null) {
			questions = new ArrayList<QuestionDTO>();
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
			for (QuestionDTO question : questions) {

				info.append("\n\n    Title: " + question.getTitle());
				info.append("\n    Text: " + question.getText());

				info.append("\n\n    Antworten:");
				for (AnswerDTO a : question.getAnswers()) {

					info.append("\n      Text: " + a.getText());
					info.append("-> " + (a.isCorrect() ? "richtig" : "falsch"));
				}
			}
		}
		return info.toString();
	}

	public ArrayList<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<QuestionDTO> questions) {
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

	@Override
	public int compareTo(ThemeDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
