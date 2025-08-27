package persistence.serialization;

import java.io.Serializable;

import persistence.DataAccesObject;

public abstract class SerializableDAO extends DataAccesObject implements Serializable{
	
	public SerializableDAO(int id) {
		super(id);
	}

	public static final long serialVersionUID = 12L;

}
