package quizlogic.fake;

import java.util.ArrayList;
import java.util.Random;

import quizlogic.Answer;
import quizlogic.Question;
import quizlogic.Theme;

public class FakeDataDeliverer {

	public ArrayList<Theme> themes;

	public FakeDataDeliverer() {
		super();
		createThemes(2);
	}

	public ArrayList<Theme> getThemes() {
		return themes;
	}

	public Question getRandomQuestion() {

		Random random = new Random();

		// Zufälliges Thema aus der Liste auswählen
		int index = random.nextInt(themes.size());
		Theme thema = themes.get(index);

		// Aus der Liste der Fragen zum ausgewählten Thema eine Frage auswählen.
		index = random.nextInt(thema.getQuestions().size());
		Question que = thema.getQuestions().get(index);

		return que;
	}

	private void createThemes(int count) {

		themes = new ArrayList<Theme>();
		Theme th;

		for (int i = 0; i < count; i++) {

			th = new Theme();
			th.setId(i);

			th.setTitle("Title des Themas  " + i);
			th.setText("Tementest blabla bla" + i);

			createQuestionsFor(th);
			themes.add(th);
		}

	}

	private void createQuestionsFor(Theme th) {

		Question q;

		for (int i = 0; i < 6; i++) {
			q = new Question(th);
			q.setId(i);
			q.setTitle("Title of the question " + i);
			q.setText("Text of the question " + i);

			th.addQuestion(q);

			createAnsersFor(q);
		}

	}

	private void createAnsersFor(Question q) {

		Answer a;

		for (int i = 0; i < Answer.MAX_ANWERS; i++) {
			a = new Answer(q);
			a.setId(i);
			a.setText("Antwort " + i);
			a.setCorrect(i % 2 == 0);

			q.addAnswer(a);
		}

	}

}
