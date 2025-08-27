package persistence.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import persistence.QuizDataInterface;
import persistence.serialization.dao.ThemeDAO;
import quizlogic.dto.AnswerDTO;
import quizlogic.dto.QuestionDTO;
import quizlogic.dto.ThemeDTO;

public class QuizDataManager implements QuizDataInterface {

	private static final String FOLDER = ".\\quizData";
	private static final String FILE = FOLDER + "\\Theme.";

	@Override
	public QuestionDTO getRandomQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ThemeDTO> getAllThemes() {
		FileInputStream fileInputStream;
		ThemeDAO theme;
		ArrayList<ThemeDTO> list = new ArrayList<>();
		try {
			File folder = new File(FOLDER);
			if (folder.list() == null)
				return null;

			for (File fileEntry : folder.listFiles()) {
				if (!fileEntry.isDirectory()) {

					fileInputStream = new FileInputStream(fileEntry);
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					theme = (ThemeDAO) objectInputStream.readObject();
					list.add((ThemeDTO) theme.toDTO());
					objectInputStream.close();
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<QuestionDTO> getQuestionsFor(ThemeDTO th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerDTO> getAnsersFor(QuestionDTO q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveTheme(ThemeDTO th) {
		
		ThemeDAO dao = new ThemeDAO(th);
		FileOutputStream fileOutputStream;
		try {
			int id = th.getId();
			if (id == -1) {
				id = createNewThemeId();
				th.setId(id);
			}
				dao.setId(id);

			fileOutputStream = new FileOutputStream(FILE + id);

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(dao);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			return e.getMessage();
		}
		return "Tas Thema wurde gespeichert";
	}

	@Override
	public String deleteTheme(ThemeDTO th) {
		File file = new File(FILE + th.getId());
		file.delete();
		return "Tas Thema wurde gelöscht";
	}

	@Override
	public String saveQuestion(QuestionDTO q) {

		return saveTheme(q.getThema());
	}

	@Override
	public String deleteQuestion(QuestionDTO q) {
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
	public QuestionDTO getRandomQuestionFor(ThemeDTO th) {
		// TODO Auto-generated method stub
		return null;
	}

}
