package gui.okkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class OkkitQFrame extends JFrame {
	public OkkitQFrame() {
		setTitle("Quiz - Erstellen und spielen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 480);
        setLocationRelativeTo(null);
        init();
//        setContentPane(new ThemeMainPanel());
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
