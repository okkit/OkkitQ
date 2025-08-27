package quizlogic;

import java.util.ArrayList;
import java.util.Comparator;

import persistence.QuizDataInterface;
import persistence.serialization.QuizDataManager;
import quizlogic.dto.AnswerDTO;
import quizlogic.dto.QuestionDTO;
import quizlogic.dto.ThemeDTO;

public class RealManager implements AppManager {

	private QuizDataInterface manager;

	public RealManager() {
		super();
		manager = Initialisation.getClassForDBManager(OkkitQConstants.INI_FILE_FOR_DB_MANAGER);
		if (manager == null) {
			manager = new QuizDataManager();
		}
	}

	@Override
	public ArrayList<ThemeDTO> getThemes() {
		
		ArrayList<ThemeDTO> list = manager.getAllThemes();
		list.sort(new Comparator<ThemeDTO>()
        {
            public int compare(ThemeDTO f1, ThemeDTO f2)
            {
                return f1.toString().compareTo(f2.toString());
            }        
        });
		
		return list;//;manager.getAllThemes();
	}

	@Override
	public QuestionDTO getRandomQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionDTO getRandomQuestionFor(ThemeDTO theme) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveTheme(ThemeDTO theme) {
	
		return manager.saveTheme(theme);
	}

	@Override
	public String deleteTheme(ThemeDTO theme) {
		return manager.deleteTheme(theme);
	}

	@Override
	public String saveAnswer(AnswerDTO answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAnswer(AnswerDTO answer) {
		// TODO Auto-generated method stub
		return null;
	}

}
