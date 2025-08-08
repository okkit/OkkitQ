package quizlogic.dto;

import quizlogic.DataTransportObject;

public class AnswerDTO extends DataTransportObject {

	private String text;
	private boolean correct;

	private QuestionDTO question;

	public AnswerDTO(QuestionDTO question) {
		super();
		this.question = question;
	}

	public AnswerDTO() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public QuestionDTO getQuestion() {
		return question;
	}

	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}

}
