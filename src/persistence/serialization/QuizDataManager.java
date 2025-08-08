package persistence.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import persistence.QuizDataInterface;
import quizlogic.Answer;
import quizlogic.Question;
import quizlogic.Theme;

public class QuizDataManager implements QuizDataInterface {

	private static final String FOLDER = ".\\quizData";
	private static final String FILE = FOLDER + "\\Theme.";

	@Override
	public Question getRandomQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Theme> getAllThemes() {
		FileInputStream fileInputStream;
		Theme theme;
		ArrayList<Theme> list = new ArrayList<>();
		try {
			File folder = new File(FOLDER);
			if (folder.list() == null)
				return null;

			for (File fileEntry : folder.listFiles()) {
				if (!fileEntry.isDirectory()) {

					fileInputStream = new FileInputStream(fileEntry);
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					theme = (Theme) objectInputStream.readObject();
					list.add(theme);
					objectInputStream.close();
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Question> getQuestionsFor(Theme th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Answer> getAnsersFor(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveTheme(Theme th) {
		FileOutputStream fileOutputStream;
		try {
			if (th.getId() == -1)
				th.setId(createNewThemeId());

			fileOutputStream = new FileOutputStream(FILE + th.getId());

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(th);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			return e.getMessage();
		}
		return "Tas Thema wurde gespeichert";
	}

	@Override
	public String deleteTheme(Theme th) {
		File file = new File(FILE + th.getId());
		file.delete();
		return "Tas Thema wurde gelöscht";
	}

	@Override
	public String saveQuestion(Question q) {

		return saveTheme(q.getThema());
	}

	@Override
	public String deleteQuestion(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getThemesCount() {

		File folder = new File(FOLDER);
		int count = 0;

		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory())
				count++;
		}
		return count;
	}

	/**
	 * id = Anzahl der Dateien im Folder + 1
	 * 
	 * @return
	 */
	public int createNewThemeId() {

		return getThemesCount() + 1;
	}

	@Override
	public Question getRandomQuestionFor(Theme th) {
		// TODO Auto-generated method stub
		return null;
	}

}
