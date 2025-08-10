package persistence.maria.createDB;

import java.util.ArrayList;

import persistence.maria.DBManager;
import quizlogic.dto.ThemeDTO;

public class Test {

	public static void main(String[] args) {

//		saveTestTheme();
		getAllThemes();

	}

	private static void getAllThemes() {

		ArrayList<ThemeDTO> list = DBManager.getInstance().getAllThemes();
		for (ThemeDTO dto : list) {
			System.out.println(dto.getFullInfo());
		}
		
	}

	private static void saveTestTheme() {
		ThemeDTO dto = new ThemeDTO();
		dto.setTitle("Test Title");
		dto.setText("Test Text");
		
		DBManager mng = DBManager.getInstance();
		String msg = mng.saveTheme(dto);
		System.out.println("Msg after save " + msg);
		
		
	}

}
