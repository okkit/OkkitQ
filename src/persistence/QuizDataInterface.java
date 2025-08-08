package persistence;

import java.util.ArrayList;

import quizlogic.dto.AnswerDTO;
import quizlogic.dto.QuestionDTO;
import quizlogic.dto.ThemeDTO;

public interface QuizDataInterface {

	public QuestionDTO getRandomQuestion();
	public QuestionDTO getRandomQuestionFor(ThemeDTO th);

	public ArrayList<ThemeDTO> getAllThemes();

	public ArrayList<QuestionDTO> getQuestionsFor(ThemeDTO th);

	public ArrayList<AnswerDTO> getAnsersFor(QuestionDTO q);
	
	
	public String saveTheme(ThemeDTO th);
	public String deleteTheme(ThemeDTO th);
	
	public String saveQuestion(QuestionDTO q);
	public String deleteQuestion(QuestionDTO q);

}

