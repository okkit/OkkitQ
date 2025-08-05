package quizlogic;

import java.io.Serializable;

/**
 * TODO java doc, with AI?
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
