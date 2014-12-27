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
	}

	public static void main(String[] args) {

//		Scanner s = new Scanner(System.in);
//
//			CheatedGame g = new CheatedGame();
//			System.out.println(g.getRemain());
//			while (g.getRemain() > 1) {
//
//				Combination cb = g.getNums().get(
//						(int) (Math.random() * g.getRemain()));
//				System.out.println("Guess Num: " + cb);
//
//				System.out.print("Pattern: ");
//				Pattern pt = new Pattern(s.nextLine());
//
//				g.makeGuess(new Guess(cb, pt));
//
//				System.out.println("Remaining: " + g.getRemain());
//
//			}
//
//			if (g.getRemain() != 0)
//				System.out.println("You win!!! Your number is: "
//						+ g.getNums().get(0));
//			else
//				System.out.println("There must be something wrong!!!");
			
		Gui window = new Gui();
		
		CheatsPanel p = new CheatsPanel();
		window.getContentPane().add(p, BorderLayout.CENTER);
		
		window.setVisible(true);

	}

}
