import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Gui extends JFrame {
	
	
	public Gui() {
		setTitle("那么问题来了");
		setSize(300,400);
		setLocationRelativeTo(null); // Appear on the center of screen
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
	}

	public static void main(String[] args) {
		Gui window = new Gui(); //Create a window
		CheatsPanel p = new CheatsPanel(); //Create the main panel
		window.getContentPane().add(p, BorderLayout.CENTER);
		window.setVisible(true);
		p.requestFocus(); //Move focus to the panel
	}

}
