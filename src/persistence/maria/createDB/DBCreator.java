package persistence.maria.createDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreator {

	private static final String URL = "jdbc:mysql://localhost:3306/OkkitQ";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private static String CREATE = "CREATE SCHEMA IF NOT EXISTS OKKITQ "
			+ "DEFAULT CHARACTER SET utf8 ;"
			+ "DROP TABLE IF EXISTS OKKIT.THEME;"
			+ "CREATE TABLE IF NOT EXISTS OKKITQ.THEME "
			+ "(ID INT NOT NULL AUTO_INCREMENT, "
			+ "TITLE VARCHAR(45) NOT NULL, "
			+ "TEXT VARCHAR(5000) NULL, "
			+ "PRIMARY KEY (ID))";

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			Statement stmt = con.createStatement();
			stmt.execute(CREATE);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
