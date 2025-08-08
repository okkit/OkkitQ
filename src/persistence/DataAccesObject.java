package persistence;

import quizlogic.DataTransportObject;

public abstract class DataAccesObject {

	private int id = -1;

	/**
	 * do not use because of forgetting to copy id. Use DataAccesObject(int id)
	 * only!
	 * 
	 * @throws Exception
	 */
	public DataAccesObject() throws Exception {
		throw new Exception(
				"do not use this constructor because of forgetting to copy id. Use DataAccesObject(int id) only!");
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

	public abstract DataTransportObject toDTO();

}
