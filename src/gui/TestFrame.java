package gui;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TestFrame extends JFrame {

	public TestFrame() throws HeadlessException {
		super();
		setBounds(600, 100, 720, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new QuizPanel());
		
		setVisible(true);
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(TestFrame::new);

	}

}
