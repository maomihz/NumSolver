package com.maomihz.core;
import java.util.ArrayList;
import java.util.List;

import com.maomihz.gui.components.Guess;
public class Game {

	private List<Guess> guesses;
	private Combination correctAns;
	public Game() {
		guesses = new ArrayList<Guess>();
		correctAns = Combination.randComb();
	}
	

	

	public int getGuessedLength() {
		return guesses.size();
	}
	
	public Combination getCorrectAns() {
		return correctAns;
	}
	
	public Pattern makeGuess(Combination g) {
		Pattern ptn = g.matches(correctAns);
		guesses.add(new Guess(g, ptn));
		return ptn;
	}
	
	
}
