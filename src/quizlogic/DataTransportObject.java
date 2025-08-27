package quizlogic;

/**
 * The class genralizes all objects of the logic layer.
 */
public abstract class DataTransportObject {

	private int id = -1;

//	public abstract String validate();

	public DataTransportObject(int id) {
		super();

		this.id = id;
	}

	public DataTransportObject() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
