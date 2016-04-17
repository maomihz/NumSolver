package com.maomihz.core;
import javax.swing.Icon;

import com.maomihz.gui.icons.CorrectIcon;
import com.maomihz.gui.icons.MatchedIcon;
import com.maomihz.gui.icons.WrongIcon;


public class Pattern {
	
	public static final Pattern WINPATTERN = new Pattern("40");
	public static final int CORRECT = 0;
	public static final int MATCHED = 1;
	public static final int WRONG = 2;
	
	private int numCorrect;
	private int numMatched;
	private int numWrong;
	
	public Pattern() {
		this(0,0,4); //Default to all wrong
	}
	
	public Pattern(int crt,int mch,int wrn) {
		numCorrect = crt;
		numMatched = mch;
		numWrong = wrn;
	}
	
	public Pattern(String ptn) {
		if (ptn.length() != 3) throw new IllegalArgumentException("Pattern String format incorrect");
		numCorrect = Integer.parseInt(ptn.substring(0,1));
		numMatched = Integer.parseInt(ptn.substring(1,2));
		numWrong = Integer.parseInt(ptn.substring(2,3));
	}
	
	public Pattern(int[] abstractPattern) { //{CORRECT, CORRECT, CORRECT, CORRECT}
		if (abstractPattern.length != 4) throw new IllegalArgumentException("Pattern Array format incorrect");
		int crt = 0;
		int mch = 0;
		int wrn = 0;
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
		return getCorrect() + getMatched() + getWrong() == 4 &&
				getCorrect() >= 0 && 
				getMatched() >= 0 && 
				getWrong() >= 0;
	}
	
	//Accessor Methods
	public int getCorrect() {
		return numCorrect;
	}
	public int getMatched() {
		return numMatched;
	}
	public int getWrong() {
		return numWrong;
	}
	
	//"1, 1, 2"
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
	
	public int[] toArray() {
		int[] ary = new int[4];
		int index = 0;
		for (int i=0;i<numCorrect;i++) {
			ary[index] = CORRECT;
			index++;
		}
		for (int i=0;i<numMatched;i++) {
			ary[index] = MATCHED;
			index++;
		}
		for (int i=0;i<numWrong;i++) {
			ary[index] = WRONG;
			index++;
		}
		return ary;
	}
	
	public boolean equals(Object anotherPattern) {
		Pattern another = (Pattern)anotherPattern;
		if (another.getCorrect() == numCorrect && another.getMatched() == numMatched && another.getWrong() == numWrong) {
			return true;
		}
		return false;
	}
	
	// Generate a random pattern
	public static Pattern randPtn() {
		int i1 = (int)(Math.random() * 5);
		int i2 = (int)(Math.random() * (4 - i1));
		int i3 = 4 - i1 - i2;
		return new Pattern(i1, i2, i3);
	}
}