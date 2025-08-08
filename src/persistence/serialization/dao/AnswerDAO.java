package persistence.serialization.dao;

import persistence.serialization.SerializableDAO;
import quizlogic.dto.AnswerDTO;

public class AnswerDAO extends SerializableDAO {

	private String text;
	private boolean correct;

	public AnswerDAO(AnswerDTO dto) {
		super(dto.getId());

		text = dto.getText();
		correct = dto.isCorrect();
	}
	
	public AnswerDTO toDTO() {
		
		AnswerDTO  dto = new AnswerDTO();
		dto.setId(getId());
		dto.setText(text);
		dto.setCorrect(correct);
		return dto;
	}

}
