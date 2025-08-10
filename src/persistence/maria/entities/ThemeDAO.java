package persistence.maria.entities;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import persistence.maria.MariaAccesObject;
import quizlogic.DataTransportObject;
import quizlogic.dto.ThemeDTO;

/**
 * This class represents the entity Theme
 */
public class ThemeDAO extends MariaAccesObject {

	private final String SQL_INSERT = "INSERT INTO okkitq.theme (TITLE, TEXT) VALUES (?, ?);";
	private final String SQL_UPDATE = "UPDATE okkitq.theme SET TITLE = ?, TEXT = ? WHERE (ID = ?);";
	
	private final String SQL_SELECT = "SELECT * from okkitq.theme;";

	private String title;
	private String text;

	/**
	 * Constructs a ThemeDAO-instance using the corresponding instance of the ThemeDTO class.
	 * @param dto
	 */
	public ThemeDAO(ThemeDTO dto) {
		super(dto.getId());
		title = dto.getTitle();
		text = dto.getText();
	}

	/**
	 * Set fields values using the result set of the SQL select command.
	 * @param row
	 */
	public ThemeDAO(Object[] row) {

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

}
