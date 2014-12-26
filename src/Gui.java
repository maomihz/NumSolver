import java.util.Scanner;


public class Gui {

	public static void main(String[] args) {
		Game g = new Game();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println(g.getRemain());
		while(g.getRemain() > 1) {
			
			Combination cb = g.getNums().get((int)(Math.random() * g.getRemain()));
			System.out.println("Guess Num: " + cb);
			
			System.out.print("Pattern: ");
			Pattern pt = new Pattern(s.nextLine());
			
			g.makeGuess(new Guess(cb, pt));
			
			System.out.println("Remaining: " + g.getRemain());
			
		}
		
		System.out.println("You win!!! Your number is: " + g.getNums().get(0));


	}

}
