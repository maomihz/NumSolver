import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame {
	
	
	public Gui() {
		super("LX Solver");
		setSize(300,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//setResizable(false);
	}

	public static void main(String[] args) {
			
		Gui window = new Gui();
		CheatsPanel p = new CheatsPanel();
		window.getContentPane().add(p, BorderLayout.CENTER);
		window.setVisible(true);
		p.requestFocus();
	}

}
