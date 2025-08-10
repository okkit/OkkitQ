package persistence.maria;

import java.sql.PreparedStatement;

import persistence.DataAccesObject;

/**
 * Class for all entity classes of package persistence.maria.entities
 */
public abstract class MariaAccesObject extends DataAccesObject {

	public MariaAccesObject(int id) {
		super(id);
	}

	public MariaAccesObject() {
		super();
	}

	/**
	 * Composes a command sql-select, that will be required of maria.DBManager.
	 * 
	 * @return sql-select statement
	 */
	public abstract String getSelectStatement();

	/**
	 * Composes a command sql-update, that will be required of maria.DBManager.
	 * 
	 * @return sql-update statement
	 */
	protected abstract String getUpdateStatement();

	/**
	 * Composes a command sql-insert, that will be required of maria.DBManager.
	 * 
	 * @return sql-insert statement 
	 */
	protected abstract String getInsertStatement();
	
	/**
	 * Prepares a sql.PreparedStatement, e.c. fills the statement with values.<br>
	 * The method will be called by maria.DBManager.
	 * 
	 * @param sql-insert statement
	 * @return
	 */
	public abstract String prepareStatement(PreparedStatement stmt);

}
