package com.maomihz.core;

public class Guess {
	private Combination num;
	private Pattern ptn;
	
	public Guess(Combination num, Pattern ptn) {
		this.num = num;
		this.ptn = ptn;
	}
	
	public Combination getComb() {
		return num;
	}
	public Pattern getPtn() {
		return ptn;
	}
}
