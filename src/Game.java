import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
public class Game {
	public static LinkedList<Combination> initNumList = new LinkedList<Combination>();
	static { //This codes are used to initialize initNumlist
		for (int a=1;a<=9;a++) { //number range 1-9
			for (int b=1;b<=9;b++) {
				if (b != a) //make sure they not repeat
				for (int c=1;c<=9;c++) {
					if (c != a && c != b)
					for (int d=1;d<=9;d++) {
						if (d != a && d != b && d != c) {
							initNumList.add(new Combination(a*1000+b*100+c*10+d));
						}
					}
				}
			}
		}
		
		//for (int i=0;i<initNumList.size();i++) System.out.println(initNumList.get(i));
		
	}
	
	private List<Combination> numList;
	private List<Guess> guesses;
	public Game() {
		numList = initNumList;
		guesses = new ArrayList<Guess>();
	}
	
	public List<Combination> getNums() {
		return numList;
	}
	

	
	public int getRemain() {
		return numList.size();
	}
	public int getGuessedLength() {
		return guesses.size();
	}
	public void makeGuess(Guess g) {
		guesses.add(g);
		for (int i=0;i<numList.size();i++) {
			Combination num = numList.get(i);
			if (!g.getComb().matches(numList.get(i)).equals(g.getPtn())) {
				numList.remove(i);
				i--;
			}
		}
//		for (int i=0;i<numList.size();i++) {
//			System.out.println(numList.get(i));
//		}
	}
	public int attemptGuess(Guess g) {
		int result = 0;
		for (int i=0;i<numList.size();i++) {
			Combination num = numList.get(i);
			if (!g.getComb().matches(numList.get(i)).equals(g.getPtn())) {
				result++;
			}
		}
		return result;
	}
}
