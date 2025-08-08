/**
 * @author ValentinaTikko
 */
package gui.swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTabbedPane;

/**
 * The class for the tab pain
 */
public class TabPane extends JTabbedPane {

	public static final Color BG_COLOR = Color.WHITE;
	private static final Font FONT_TAB = new Font("Arial", Font.PLAIN, 16);

	/**
	 * Constructs a tab pane and set its appearance
	 */
	public TabPane() {
		super(JTabbedPane.TOP);
		setFont(FONT_TAB);
		setBackground(BG_COLOR);
	}
}

