package persistence.serialization;

import persistence.DataAccesObject;

public abstract class SerializableDAO extends DataAccesObject{
	
	public SerializableDAO(int id) {
		super(id);
	}

	protected static final long serialVersionUID = 1L;

}
