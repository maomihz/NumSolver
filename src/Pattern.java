import javax.swing.Icon;


public class Pattern {
	
	public static final Pattern WINPATTERN = new Pattern("40");
	public static final int CORRECT = 0;
	public static final int MATCHED = 1;
	public static final int WRONG = 2;
	
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
	
	public Pattern(int[] abstractPattern) {
		int crt=0, mch=0, wrn=0;
		for (int i=0;i<abstractPattern.length;i++) {
			if (abstractPattern[i] == CORRECT) crt++;
			if (abstractPattern[i] == MATCHED) mch++;
			if (abstractPattern[i] == WRONG) wrn++;
		}
		numCorrect = crt;
		numMatched = mch;
		numWrong = wrn;
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
	public Icon[] toIcon(int size) {
		Icon[] icons = new Icon[4];
		int index = 0;
		for (int i=0;i<numCorrect;i++) {
			icons[index] = new CorrectIcon(size);
			index++;
		}
		for (int i=0;i<numMatched;i++) {
			icons[index] = new MatchedIcon(size);
			index++;
		}
		for (int i=0;i<numWrong;i++) {
			icons[index] = new WrongIcon(size);
			index++;
		}
		return icons;
		
	}
	
	public boolean equals(Object anotherPattern) {
		Pattern another = (Pattern)anotherPattern;
		if (another.getCorrect() == numCorrect && another.getMatched() == numMatched && another.getWrong() == numWrong) {
			return true;
		}
		return false;
	}
	
	public static Pattern randPtn() {
		int i1 = (int)(Math.random() * 5);
		int i2 = (int)(Math.random() * (4 - i1));
		int i3 = 4 - i1 - i2;
		return new Pattern(i1, i2, i3);
	}
}
