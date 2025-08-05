package persistence.serialization.test;

import java.util.ArrayList;

import persistence.QuizDataInterface;
import persistence.serialization.QuizDataManager;
import quizlogic.FakeDataDeliverer;
import quizlogic.Question;
import quizlogic.Thema;

public class Test {

	public static void main(String[] args) {

		FakeDataDeliverer fdd = new FakeDataDeliverer();
		ArrayList<Thema> list = fdd.getThemes();

		QuizDataInterface manager = new QuizDataManager();
		Question q = fdd.getRandomQuestion();
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
		ArrayList<Thema> list2 = manager.getAllThemes();

		for (Thema thema : list2) {
			System.out.println(thema);
		}

	}

}
