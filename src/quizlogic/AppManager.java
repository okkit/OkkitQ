/**
 * @author ValentinaTikko
 */
package quizlogic;

import java.util.ArrayList;

/**
 * This interface describes the features of a class, which manages:
 * 1. the business logic e.c. validation of the input data<br>
 * 2. data transfer between the GUI and persistence layers.
 * 
 */
public interface AppManager {

	public ArrayList<Theme> getThemes();

	public Question getRandomQuestion();

	public void createThemes(int count);

	public void createQuestionsFor(Theme th);

	public void createAnsersFor(Question q);

}
