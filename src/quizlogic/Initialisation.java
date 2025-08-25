package quizlogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import persistence.QuizDataInterface;

public class Initialisation {

	public static AppManager getClassForAppManager(String iniFile) {

		String className = getClassName(iniFile);
		if (className == null)
			return null;
		Class<?> mngClass;
		try {
			mngClass = Class.forName(className);
			AppManager manager = (AppManager) mngClass.getConstructor().newInstance();
			return manager;
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static QuizDataInterface getClassForDBManager(String iniFile) {

		String className = getClassName(iniFile);
		if (className.equals("persistence.serialization.QuizDataManager"))
			return new persistence.serialization.QuizDataManager();
		else if (className.equals("persistence.maria.DBManager"))
			return persistence.maria.DBManager.getInstance();
		return null;
	}


	private static String getClassName(String file) {
		String name = null;
		try {
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				name = myReader.nextLine();
				if (name.indexOf("//") < 0)
				break;
			}
			myReader.close();
			return name;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
