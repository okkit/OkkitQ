package persistence.serialization.dao;

import java.util.ArrayList;

import persistence.serialization.SerializableDAO;
import quizlogic.DataTransportObject;
import quizlogic.dto.QuestionDTO;
import quizlogic.dto.ThemeDTO;

public class ThemeDAO extends SerializableDAO {

	private String title;
	private String text;
	private ArrayList<QuestionDAO> questions;

	public ThemeDAO(ThemeDTO dto) {

		super(dto.getId());
		title = dto.getTitle();
		text = dto.getText();

		questions = new ArrayList<QuestionDAO>(dto.getQuestions().size());
		for (QuestionDTO qDto : dto.getQuestions()) {
			questions.add(new QuestionDAO(qDto));
		}
	}

	@Override
	public DataTransportObject toDTO() {

		ThemeDTO dto = new ThemeDTO();
		dto.setId(getId());
		return null;
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
