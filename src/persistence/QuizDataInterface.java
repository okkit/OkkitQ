package persistence;

import java.util.ArrayList;

import quizlogic.Answer;
import quizlogic.Question;
import quizlogic.Theme;

public interface QuizDataInterface {

	public Question getRandomQuestion();

	public ArrayList<Theme> getAllThemes();

	public ArrayList<Question> getQuestionsFor(Theme th);

	public ArrayList<Answer> getAnsersFor(Question q);
	
	
	public String saveTheme(Theme th);
	public String deleteTheme(Theme th);
	
	public String saveQuestion(Question q);
	public String deleteQuestion(Question q);

}

