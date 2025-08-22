package persistence.maria.createDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DBCreator {

	public static void main(String[] args) {

		createOKKITQ();
		createTABLES();
		insertThemes();

	}

	private static final String URL = "jdbc:mysql://localhost:3306?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private static String CREATE_SCHEMA = "CREATE SCHEMA IF NOT EXISTS OKKITQ DEFAULT CHARACTER SET utf8 ;";

	private static String CREATE_THEME = "DROP TABLE IF EXISTS OKKIT.THEME;"
			+ "CREATE TABLE IF NOT EXISTS OKKITQ.THEME " + "(ID INT NOT NULL AUTO_INCREMENT, "
			+ "TITLE VARCHAR(45) NOT NULL, " + "TEXT VARCHAR(5000) NULL, " + "PRIMARY KEY (ID))";

	private static String CREATE_QUESTION = "DROP TABLE IF EXISTS OKKITQ.QUESTION ;"
			+ "CREATE TABLE IF NOT EXISTS OKKITQ.QUESTION (" + "  ID INT NOT NULL AUTO_INCREMENT,"
			+ "  TITLE VARCHAR(45) NOT NULL," + "  TEXT VARCHAR(500) NULL,"
			+ "  THEME_ID INT NOT NULL," + "  PRIMARY KEY (ID, THEME_ID))";

	private static String CREATE_ANSWER = "DROP TABLE IF EXISTS OKKITQ.ANSWER ;" + ""
			+ "CREATE TABLE IF NOT EXISTS OKKITQ.ANSWER (" + "  ID INT NOT NULL AUTO_INCREMENT,"
			+ "  TEXT VARCHAR(150) NULL," + "  ISTRUE TINYINT NULL," + "  QUESTION_ID INT NOT NULL,"
			+ "  PRIMARY KEY (ID, QUESTION_ID))";

	private static void createOKKITQ() {

		System.out.println("Create Database OKKITQ");
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			Statement stmt = con.createStatement();
			stmt.execute(CREATE_SCHEMA);
			stmt.close();

			System.out.println("Databes is created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void createTABLES() {

		System.out.println("Create Tables");
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			Statement stmt = con.createStatement();
			System.out.println("Create Table THEME");
			stmt.execute(CREATE_THEME);
			System.out.println("Create Table QUESTION");
			stmt.execute(CREATE_QUESTION);
			System.out.println("Create Table ANSWER");
			stmt.execute(CREATE_ANSWER);
			stmt.close();
			System.out.println("Tables are created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static int THEME_COUNT = 10;
	private static int MAX_QUESTION_COUNT = 10;
	private static int MIN_ANSWER_COUNT = 2;
	private static int MAX_ANSWER_COUNT = 4;

	private static void insertThemes() {

		Object[] values = new Object[3];
		for (int i = 0; i < THEME_COUNT; i++) {
			values[0] = "Thema Numero i";
			values[1] = "Ausführliche Information zum Thema Numero i";
			values[2] = null;
			int pk = insert(INSERT_THEME, values);
			insertQuestionFor(pk);
		}
	}

	private static void insertQuestionFor(int id_theme) {

		Object[] values = new Object[3];
		Random rand = new Random();
		for (int i = 0; i < rand.nextInt(0, MAX_QUESTION_COUNT); i++) {
			values[0] = i + ". Frage zum Thema " + id_theme;
			values[1] = i + "Fr.: Die eigentliche Frage, die gestellt wird";
			values[2] = id_theme;
			int pk = insert(INSERT_QUESTION, values);
			insertAnswersFor(pk);
		}
	}

	private static void insertAnswersFor(int id_question) {

		Object[] values = new Object[3];
		Random rand = new Random();
		for (int i = 0; i < rand.nextInt(MIN_ANSWER_COUNT, MAX_ANSWER_COUNT); i++) {
			values[0] = i + ". Answer zur Frage " + id_question;
			values[1] = rand.nextBoolean();
			values[2] = id_question;
			insert(INSERT_ANSWER, values);
		}
	}

	private static String INSERT_THEME = "INSERT INTO okkitq.theme (TITLE, TEXT) VALUES (?, ?);";
	private static String INSERT_QUESTION = "INSERT INTO okkitq.question (TITLE, TEXT, THEME_ID) VALUES (?, ?, ?);";
	private static String INSERT_ANSWER = "INSERT INTO okkitq.answer (TEXT, ISTRUE, QUESTION_ID) VALUES (?, ?, ?);";

	private static int insert(String sql, Object[] values) {

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS)) {

			for (int i = 0; i < values.length; i++) {
				Object value = values[i];
				if (value != null) {
					if (value instanceof Integer)
						stmt.setInt(i + 1, (int) value);
					else if (value instanceof String)
						stmt.setString(i + 1, (String) value);
					else if (value instanceof Boolean)
						stmt.setBoolean(i + 1, (boolean) value);
				}
			}
			stmt.execute();

			ResultSet res = stmt.getGeneratedKeys();
			if (res.next()) {
				return res.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
