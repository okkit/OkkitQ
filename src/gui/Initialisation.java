package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import quizlogic.AppManager;

public class Initialisation {

	public static AppManager getClassForAppManager() {

		String className = getClassName();
		if (className == null)
			return null;
		Class<?> mngClass;
		try {
			mngClass = Class.forName(className);
			AppManager manager = (AppManager) mngClass.getConstructor().newInstance();
			System.out.println(manager);
			return manager;
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static String getClassName() {
		String name = null;
		try {
			File myObj = new File(".\\okkitq.ini");
			Scanner myReader = new Scanner(myObj);
			if (myReader.hasNextLine()) {
				name = myReader.nextLine();
			}
			myReader.close();
			return name;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
