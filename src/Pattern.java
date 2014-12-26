
public class Pattern {
	
	public static final Pattern WINPATTERN = new Pattern("40");
	
	private int numCorrect;
	private int numMatched;
	private int numWrong;
	
	public Pattern() {
		this(0,0,4);
	}
	
	public Pattern(int crt,int mch,int wrn) {
		numCorrect = crt;
		numMatched = mch;
		numWrong = wrn;

	}
	public Pattern(String ptn) {
		if (ptn.length() < 2 || ptn.length() > 3) throw new IllegalArgumentException();
		numCorrect = Integer.parseInt(ptn.substring(0,1));
		numMatched = Integer.parseInt(ptn.substring(1,2));
		if (ptn.length() == 2) {
			numWrong = 4-numCorrect-numMatched;
		} else {
			numWrong = Integer.parseInt(ptn.substring(2,3));
		}
	}
	
	public boolean checkValid() {
		return getCorrect() + getMatched() + getWrong() == 4 && getCorrect() >= 0 && getMatched() >= 0 && getWrong() >= 0;
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
