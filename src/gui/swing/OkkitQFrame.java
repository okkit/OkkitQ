package gui.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class OkkitQFrame extends JFrame {
	public OkkitQFrame() {
		setTitle("Quiz - Erstellen und spielen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 480);
		setLocationRelativeTo(null);
		init();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//TODO Before the app closing
				System.out.println("Die Anwendung wird beendet");
			}
		});
	}

	/**
	 * Initialize the tab-bar and its corresponding panels
	 */
	private void init() {

		TabPane themeTab = new TabPane();
		add(themeTab);

		themeTab.addTab("Themen", new ThemeMainPanel());

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new OkkitQFrame().setVisible(true));
	}
}
