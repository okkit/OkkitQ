/**
 * @author ValentinaTikko
 */
package persistence.maria.entities;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import persistence.maria.MariaAccesObject;
import quizlogic.DataTransportObject;
import quizlogic.dto.ThemeDTO;

/**
 * This class represents the entity Theme
 */
public class QuestionDAO extends MariaAccesObject {

	private final String SQL_INSERT = "INSERT INTO okkitq.question (TITLE, TEXT, THEME_ID) VALUES (?, ?, ?);";
	private final String SQL_UPDATE = "UPDATE okkitq.question SET TITLE = ?, TEXT = ?, THEME_ID = ? WHERE (ID = ?);";

	private final String SQL_SELECT = "SELECT * from okkitq.question;";

	private String title;
	private String text;
	private int theme_id;

	/**
	 * Constructs a ThemeDAO-instance using the corresponding instance of the
	 * ThemeDTO class.
	 * 
	 * @param dto
	 */
	public QuestionDAO(ThemeDTO dto) {
		super(dto.getId());
		title = dto.getTitle();
		text = dto.getText();
	}

	/**
	 * Set fields values using the result set of the SQL select command.
	 * 
	 * @param row
	 */
	public QuestionDAO(Object[] row) {

		super();
		id = (int) row[0];
		title = (String) row[1];
		text = (String) row[2];
	}

	@Override
	public String getSelectStatement() {
		return SQL_SELECT;
	}

	@Override
	public String prepareStatement(PreparedStatement stmt) {
		try {
			stmt.setString(1, title);
			stmt.setString(2, text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Gespeichert";
	}

	@Override
	public String getInsertStatement() {
		return SQL_INSERT;
	}

	@Override
	public String getUpdateStatement() {
		return SQL_UPDATE;
	}

	@Override
	public DataTransportObject toDTO() {
		ThemeDTO dto = new ThemeDTO();
		dto.setId(id);
		dto.setTitle(title);
		dto.setText(text);
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

	public int getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(int theme_id) {
		this.theme_id = theme_id;
	}

}
