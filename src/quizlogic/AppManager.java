/**
 * @author ValentinaTikko
 */
package quizlogic;

import java.util.ArrayList;

import quizlogic.dto.AnswerDTO;
import quizlogic.dto.QuestionDTO;
import quizlogic.dto.ThemeDTO;

/**
 * This interface describes the features of a class, which manages: 1. the
 * business logic e.c. validation of the input data<br>
 * 2. data transfer between the GUI and persistence layers.
 * 
 */
public interface AppManager {

	public ArrayList<ThemeDTO> getThemes();

	public QuestionDTO getRandomQuestion();
	
	public QuestionDTO getRandomQuestionFor(ThemeDTO theme);

	public String saveTheme(ThemeDTO theme);

	public String deleteTheme(ThemeDTO theme);

	public String saveAnswer(AnswerDTO answer);

	public String deleteAnswer(AnswerDTO answer);

}
