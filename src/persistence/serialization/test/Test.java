package persistence.serialization.test;

import java.util.ArrayList;

import persistence.QuizDataInterface;
import persistence.serialization.QuizDataManager;
import quizlogic.dto.QuestionDTO;
import quizlogic.dto.ThemeDTO;

public class Test {

	public static void main(String[] args) {


		QuizDataInterface manager = new QuizDataManager();
		QuestionDTO q = manager.getRandomQuestion();
		q.getThema().setId(-1);
		q.getThema().setTitle("THEMA AUS DEM tEST");
		manager.saveQuestion(q);
		

//		for (Thema thema : list) {
//			System.out.println(thema);
//			manager.saveTheme(thema);
//			System.out.println(thema);
//		}

		showAllThemes();
	}

	private static void showAllThemes() {
		QuizDataInterface manager = new QuizDataManager();
		ArrayList<ThemeDTO> list2 = manager.getAllThemes();

		for (ThemeDTO thema : list2) {
			System.out.println(thema);
		}

	}

}
