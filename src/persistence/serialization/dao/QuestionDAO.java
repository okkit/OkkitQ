package persistence.serialization.dao;

import java.util.ArrayList;

import persistence.serialization.SerializableDAO;
import quizlogic.DataTransportObject;
import quizlogic.dto.AnswerDTO;
import quizlogic.dto.QuestionDTO;

public class QuestionDAO extends SerializableDAO {

	private String title;
	private String text;
	private ArrayList<AnswerDAO> answers;

	public QuestionDAO(QuestionDTO dto) {
		super(dto.getId());

		title = dto.getTitle();
		answers = new ArrayList<AnswerDAO>(dto.getAnswers().size());
		for (AnswerDTO aDto : dto.getAnswers()) {
			answers.add(new AnswerDAO(aDto));
		}

	}

	@Override
	public DataTransportObject toDTO() {
		QuestionDTO dto = new QuestionDTO();
		dto.setId(getId());
		dto.setTitle(title);
		dto.setText(text);
		return dto;
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
