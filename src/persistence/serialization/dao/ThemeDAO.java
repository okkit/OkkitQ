package persistence.serialization.dao;

import java.util.ArrayList;

import persistence.serialization.SerializableDAO;
import quizlogic.DataTransportObject;
import quizlogic.dto.AnswerDTO;
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

//		if (dto.getQuestions() != null) {
//			questions = new ArrayList<QuestionDAO>(dto.getQuestions().size());
//			for (QuestionDTO qDto : dto.getQuestions()) {
//				QuestionDAO qDao = new QuestionDAO(qDto);
//				questions.add(qDao);
//				
//				if (qDto.getAnswers() != null) {
//					ArrayList<AnswerDAO> answers = new ArrayList<AnswerDAO>(qDto.getAnswers().size());
//					for (AnswerDTO aDto : qDto.getAnswers()) {
//						answers.add(new AnswerDAO(aDto));
//					}
//				}
//			}
//		}
	}

	@Override
	public DataTransportObject toDTO() {

		ThemeDTO dto = new ThemeDTO();
		dto.setId(getId());
		dto.setTitle(title);
		dto.setText(text);

		if (questions != null) {
			ArrayList<QuestionDTO> qDtoS = new ArrayList<QuestionDTO>(questions.size());
			for (QuestionDAO questionDAO : questions) {
				qDtoS.add((QuestionDTO) questionDAO.toDTO());

				if (questionDAO.getAnswers() != null) {
					ArrayList<AnswerDTO> aDtoS = new ArrayList<AnswerDTO>(
							questionDAO.getAnswers().size());

					for (AnswerDAO answerDAO : questionDAO.getAnswers()) {
						aDtoS.add((AnswerDTO) answerDAO.toDTO());
					}
				}
			}
		}
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
