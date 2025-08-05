package gui.okkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class OkkitQFrame extends JFrame {
	public OkkitQFrame() {
		setTitle("Examen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 480);
        setLocationRelativeTo(null);
        setContentPane(new ThemeMainPanel());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new OkkitQFrame().setVisible(true));
	}
}
