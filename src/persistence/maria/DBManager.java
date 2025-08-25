package persistence.maria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import persistence.QuizDataInterface;
import persistence.maria.entities.ThemeDAO;
import quizlogic.dto.AnswerDTO;
import quizlogic.dto.QuestionDTO;
import quizlogic.dto.ThemeDTO;

/**
 * The class manages all interactions with the MySQL data base.<br>
 * The class is a singleton
 */
public class DBManager implements QuizDataInterface {

	/**
	 * Link zu der Datenbank
	 */
	private static final String URL = "jdbc:mysql://localhost:3306/OkkitQ";
	/**
	 * Benutzer
	 */
	private static final String USER = "root";
	/**
	 * Password
	 */
	private static final String PASSWORD = "";

	/**
	 * Instance of class. There is one instance only.
	 */

	private static DBManager instance;
	/**
	 * Connection to the data base. Has to be opened before executing any
	 * sql-statement an closed in all cases, the application exits.
	 */
	private Connection connection;

	/**
	 * Has to be private because is a singleton
	 */
	private DBManager() {
	}

	/**
	 * The only possible access to the instance of the single class
	 * 
	 * @return
	 */
	public static DBManager getInstance() {
		if (instance == null)
			instance = new DBManager();
		return instance;
	}

	/**
	 * Manages the opening of the connection to the database.
	 * 
	 * @return
	 */
	private Connection getConnection() {
		if (connection == null)
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				return null;
			}
		return connection;
	}

	/**
	 * Closes the connection to the data base. Will be called from the class, which
	 * has the main-method.
	 */
	public void closeConnectionToDB() {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * Saves a instance of MariaAccesObject into the data base. <br>
	 * The method is designed generically - it works with the abstract <br>
	 * super class MariaAccesObject, NOT with concrete classes like Theme or
	 * Questions.<br>
	 * 
	 * For saving of an instance of a concrete class the method uses one of the
	 * methods<br>
	 * of the concrete class to obtain the SQL-Command ((getInsertStatement() or
	 * dao.getUpdateStatement()).<br>
	 * 
	 * @param dao
	 * @return error text if error occurred otherwise null
	 */
	public String saveDao(MariaAccesObject dao) {

		boolean isNew = dao.getId() < 0;

		Connection con = getConnection();
		try {
			con.setAutoCommit(false);
			String command = isNew ? dao.getInsertStatement() : dao.getUpdateStatement();
			PreparedStatement stmt = con.prepareStatement(command, Statement.RETURN_GENERATED_KEYS);
			dao.prepareStatement(stmt);
			stmt.execute();
			con.commit();
			ResultSet res = stmt.getGeneratedKeys();
			if (res.next()) {
				dao.setId(res.getInt(1));
			}
			stmt.close();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				return e1.getMessage();
			}
			return e.getMessage();
		}
		return null;
	}

	/**
	 * The method is designed generically - it works with the abstract super<br>
	 * class MariaAccesObject, NOT with concrete classes like Theme or
	 * Questions.<br>
	 * 
	 * @param table
	 * @return the list of 
	 */
	public ArrayList<Object[]> getAll(String table) {

		ArrayList<Object[]> all = new ArrayList<Object[]>();
		try {

			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = connection.createStatement();
			String sqlQuery = "select * from " + table;
			ResultSet result = stmt.executeQuery(sqlQuery);

			int columnCount = result.getMetaData().getColumnCount();
			Object[] rowData;

			while (result.next()) {
				rowData = new Object[columnCount];
				for (int i = 0; i < columnCount; i++) {
					rowData[i] = result.getObject(i + 1);
				}
				all.add(rowData);
			}

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}
	
	private String deleteDAO(String daoName, int daoID) {
		
		if (daoID < 0)
			return daoName + "kann nicht gelöscht werden, da nicht existiert";
		
		String command = "delete from " + daoName + " where id = ?";
		
		
		Connection con = getConnection();
		try (PreparedStatement stmt = con.prepareStatement(command)){
			
			con.setAutoCommit(false);	
			stmt.setInt(1, daoID);
			stmt.execute();
			con.commit();
			stmt.close();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				return e1.getMessage();
			}
			return e.getMessage();
		}
		return "Das " + daoName + " wurde gelöscht";
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

		ArrayList<Object[]> data = getAll("Theme");
		ArrayList<ThemeDTO> all = new ArrayList<ThemeDTO>(data.size());

		for (Object[] row : data) {

			all.add((ThemeDTO) (new ThemeDAO(row)).toDTO());

		}
		return all;
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

		ThemeDAO dao = new ThemeDAO(th);
		return saveDao(dao);
	}

	@Override
	public String deleteTheme(ThemeDTO th) {
		
		return deleteDAO("Theme", th.getId());
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
