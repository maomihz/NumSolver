import java.util.LinkedList;
import java.util.List;


public class CheatedGame {
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
		
	}
	
	private List<Combination> numList;
	private List<List<Combination>> changeHistory;
	
	public CheatedGame() {
		numList = new LinkedList<Combination>();
		for (Combination c : initNumList) {
			numList.add(c);
		}
		changeHistory = new LinkedList<List<Combination>>();
	}
	
	public List<Combination> getNums() {
		return numList;
	}
	
	public List<Combination> getHistory(int num) {
		return changeHistory.get(changeHistory.size() - num);
	}
	
	public int getRemain() {
		return numList.size();
	}
	
	public Combination getNextGuess() {
		return numList.get((int)(Math.random() * getRemain()));
	}
	
	public void makeGuess(Guess g) {
		List<Combination> hisList = new LinkedList<Combination>();
		for (int i=0;i<numList.size();i++) {
			Combination num = numList.get(i);
			if (!g.getComb().matches(numList.get(i)).equals(g.getPtn())) {
				hisList.add(numList.remove(i));
				i--;
			}
		}
		
		changeHistory.add(hisList);
		
	}
	
}
