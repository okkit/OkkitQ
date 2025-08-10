package persistence;

import quizlogic.DataTransportObject;

/**
 * The class generalizes all persistently saveable classes.
 */
public abstract class DataAccesObject {

	protected int id = -1;
	
	/**
	 * Converts a DataAccesObject to a DataAccesObject.<br>
	 * Evry class that extens this class have to implement this method. 
	 * @return
	 */
	public abstract DataTransportObject toDTO();

	public DataAccesObject() {
		super();
	}

	public DataAccesObject(int id) {
		super();

		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
