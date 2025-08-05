package persistence;

import java.util.ArrayList;

import quizlogic.Answer;
import quizlogic.Question;
import quizlogic.Thema;

public interface QuizDataInterface {

	public Question getRandomQuestion();

	public ArrayList<Thema> getAllThemes();

	public ArrayList<Question> getQuestionsFor(Thema th);

	public ArrayList<Answer> getAnsersFor(Question q);
	
	
	public String saveTheme(Thema th);
	public String deleteTheme(Thema th);
	
	public String saveQuestion(Question q);
	public String deleteQuestion(Question q);

}

