package quizlogic.fake;

import java.util.ArrayList;
import java.util.Random;

import quizlogic.AppManager;
import quizlogic.dto.AnswerDTO;
import quizlogic.dto.QuestionDTO;
import quizlogic.dto.ThemeDTO;

public class FakeManager implements AppManager {
	public static final int MAX_ANWERS = 4;
	public ArrayList<ThemeDTO> themes;

	public FakeManager() {
		super();
		createThemes(2);
	}

	@Override
	public ArrayList<ThemeDTO> getThemes() {
		return themes;
	}

	@Override
	public QuestionDTO getRandomQuestion() {
		return getRandomQuestionFor(null);
	}

	@Override
	public QuestionDTO getRandomQuestionFor(ThemeDTO th) {
		Random random = new Random();
		ThemeDTO theme = th;

		if (theme == null) {
			// Zufälliges Thema aus der Liste auswählen
			theme = themes.get(random.nextInt(themes.size()));
		}

		// Aus der Liste der Fragen zum ausgewählten Thema eine Frage auswählen.
		int index = random.nextInt(theme.getQuestions().size());
		QuestionDTO que = theme.getQuestions().get(index);

		return que;
	}

	@Override
	public String saveTheme(ThemeDTO theme) {
		return "saveTheme ist noch nicht implementiert";
	}

	@Override
	public String deleteTheme(ThemeDTO theme) {
		return "deleteTheme ist noch nicht implementiert";
	}

	@Override
	public String saveAnswer(AnswerDTO answer) {
		return "saveAnswer ist noch nicht implementiert";
	}

	@Override
	public String deleteAnswer(AnswerDTO answer) {
		return "deleteAnswer ist noch nicht implementiert";
	}

	private void createThemes(int count) {

		themes = new ArrayList<ThemeDTO>();
		ThemeDTO th;

		for (int i = 0; i < count; i++) {

			th = new ThemeDTO();
			th.setId(i);

			th.setTitle("Title des Themas  " + i);
			th.setText("Tementest blabla bla" + i);

			createQuestionsFor(th);
			themes.add(th);
		}

	}

	private void createQuestionsFor(ThemeDTO th) {

		QuestionDTO q;

		for (int i = 0; i < 6; i++) {
			q = new QuestionDTO(th);
			q.setId(i);
			q.setTitle("Title of the question " + i);
			q.setText("Text of the question " + i);

			th.addQuestion(q);

			createAnsersFor(q);
		}

	}

	private void createAnsersFor(QuestionDTO q) {

		AnswerDTO a;

		for (int i = 0; i < MAX_ANWERS; i++) {
			a = new AnswerDTO(q);
			a.setId(i);
			a.setText("Antwort " + i);
			a.setCorrect(i % 2 == 0);

			q.addAnswer(a);
		}

	}
}
