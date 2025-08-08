package persistence.maria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import persistence.QuizDataInterface;
import quizlogic.dto.AnswerDTO;
import quizlogic.dto.QuestionDTO;
import quizlogic.dto.ThemeDTO;

/**
 * The class manages all interactions with the MySQL data base.<br>
 * The class is a singleton
 */
public class DBManager implements QuizDataInterface{
	
	private static DBManager instance;
	private Connection connection;
	
	private DBManager() {
	}
	
	public static DBManager getInstance() {
		if (instance == null)
			instance = new DBManager();
		return instance;
	}
	
	public Connection getConnection() {
		if (connection == null)
			try {
				connection = DriverManager.getConnection(null, null, null);
			} catch (SQLException e) {
//				e.printStackTrace();
				return null;
			}
		return connection;
	}
	
	public void closeConnectionToDB() {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public QuestionDTO getRandomQuestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public QuestionDTO getRandomQuestionFor(ThemeDTO th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ThemeDTO> getAllThemes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<QuestionDTO> getQuestionsFor(ThemeDTO th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerDTO> getAnsersFor(QuestionDTO q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveTheme(ThemeDTO th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTheme(ThemeDTO th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveQuestion(QuestionDTO q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteQuestion(QuestionDTO q) {
		// TODO Auto-generated method stub
		return null;
	}

}
