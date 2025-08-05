package quizlogic;

import java.io.Serializable;

/**
 * Die MutterKlasse aller Objekte in der busineslogic-Schicht werden serialisierbar,<br
 * d.h. implementes Serializable und serialVersionUID
 */
public class QObject implements Serializable{
	
	protected static final long serialVersionUID = 1L;
	
	private int id = -1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
