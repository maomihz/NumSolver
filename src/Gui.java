import java.util.Scanner;


public class Gui {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		if (s.nextLine().equals("9999")) {
		CheatedGame g = new CheatedGame();
		System.out.println(g.getRemain());
		while(g.getRemain() > 1) {
			
			Combination cb = g.getNums().get((int)(Math.random() * g.getRemain()));
			System.out.println("Guess Num: " + cb);
			
			System.out.print("Pattern: ");
			Pattern pt = new Pattern(s.nextLine());
			
			g.makeGuess(new Guess(cb, pt));
			
			System.out.println("Remaining: " + g.getRemain());
			
		}
		
		if (g.getRemain() != 0)
			System.out.println("You win!!! Your number is: " + g.getNums().get(0));
		else
			System.out.println("There must be something wrong!!!");
		
		} else {
		
		Game g = new Game();
		System.out.println("Game Started!!!");
		Pattern theptn;
		do {
			System.out.print("Make a guess: ");
			theptn = g.makeGuess(new Combination(s.nextLine()));
			System.out.println(theptn);
		} while(!theptn.equals(Pattern.WINPATTERN));
		
		}
	}

}
