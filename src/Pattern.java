
public class Pattern {
	
	public static final Pattern WINPATTERN = new Pattern("40");
	
	private int numCorrect;
	private int numMatched;
	private int numWrong;
	
	public Pattern() {
		this(0,0,4);
	}
	
	public Pattern(int crt,int mch,int wrn) {
		if (crt + mch + wrn == 4 && crt >= 0 && mch >= 0 && wrn >= 0) { //ensure the sum of patterns are 4
			numCorrect = crt;
			numMatched = mch;
			numWrong = wrn;
		} else {
			throw new IllegalArgumentException();
		}

	}
	public Pattern(String ptn) {
		numCorrect = Integer.parseInt(ptn.substring(0,1));
		numMatched = Integer.parseInt(ptn.substring(1,2));
		numWrong = 4-numCorrect-numMatched;
	}
	
	public int getCorrect() {
		return numCorrect;
	}
	public int getMatched() {
		return numMatched;
	}
	public int getWrong() {
		return numWrong;
	}
	
	public String toString() {
		return String.format("%d, %d, %d", numCorrect, numMatched, numWrong);
	}
	
	public boolean equals(Object anotherPattern) {
		Pattern another = (Pattern)anotherPattern;
		if (another.getCorrect() == numCorrect && another.getMatched() == numMatched && another.getWrong() == numWrong) {
			return true;
		}
		return false;
	}
}
