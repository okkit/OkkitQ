package quizlogic.dto;

import java.util.ArrayList;

import quizlogic.DataTransportObject;

public class QuestionDTO extends DataTransportObject {

	private String title;
	private String text;

	private ThemeDTO thema;
	private ArrayList<AnswerDTO> answers;

	public QuestionDTO(ThemeDTO thema) {
		super();
		this.thema = thema;
	}
	
	
	public QuestionDTO() {
		super();
	}


	public ArrayList<AnswerDTO> getAnswers() {
		return answers;
	}


	public void addAnswer(AnswerDTO a) {
		
		if (answers == null) {
			answers = new ArrayList<AnswerDTO>();
		}
		answers.add(a);
	}

	public ThemeDTO getThema() {
		return thema;
	}

	public void setThema(ThemeDTO thema) {
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
