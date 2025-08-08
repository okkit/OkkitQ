package persistence.maria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import persistence.QuizDataInterface;
import quizlogic.Answer;
import quizlogic.Question;
import quizlogic.Theme;

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
	public Question getRandomQuestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Question getRandomQuestionFor(Theme th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Theme> getAllThemes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Question> getQuestionsFor(Theme th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Answer> getAnsersFor(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveTheme(Theme th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTheme(Theme th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveQuestion(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteQuestion(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

}
