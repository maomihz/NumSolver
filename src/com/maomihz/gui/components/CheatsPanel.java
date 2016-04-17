package com.maomihz.gui.components;
import javax.swing.JPanel;

import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.event.*;

import com.maomihz.core.Combination;
import com.maomihz.core.Pattern;
import com.maomihz.gui.icons.CorrectIcon;
import com.maomihz.gui.icons.MatchedIcon;
import com.maomihz.gui.icons.WrongIcon;


public class CheatsPanel extends JPanel implements ActionListener, KeyListener {
	
	private CheatedGame g;
	private int currentIndex; //Start from 0 and when there's input +1 undo -1
	private ArrayList<JLabel> labelsList;
	private int[] patternList;
	private ArrayList<JLabel> numLabelsList;
	private Combination currentGuess;
	private ArrayList<Guess> guessHistory;
	
	private JButton btnCorrect, btnMatched, btnWrong;
	private JButton btnRestart, btnUndo, btnAbout;
	
	private void setup() {
		removeAll();
		g = new CheatedGame();
		labelsList = new ArrayList<JLabel>();
		currentIndex = 0;
		patternList = new int[4];
		numLabelsList = new ArrayList<JLabel>();
		currentGuess = g.getNextGuess();
		guessHistory = new ArrayList<Guess>();
		
		for (int i=0;i<10;i++) {
			JLabel btn = new JLabel(String.valueOf(i+1));
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			add(btn);
			JLabel label = new JLabel();
			label.setBackground(Color.green);
			label.setOpaque(true);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			add(label);
			numLabelsList.add(label);
			
			JLabel[] results = new JLabel[4];
			for (int a=0;a<4;a++) {
				results[a] = new JLabel();
				results[a].setHorizontalAlignment(SwingConstants.CENTER);
				add(results[a]);
				labelsList.add(results[a]);
			}
		}
		
		numLabelsList.get(currentIndex / 4).setText(currentGuess.toString());
		
		btnCorrect = new JButton();
		btnCorrect.setBorderPainted(false);
		btnCorrect.setIcon(new CorrectIcon());
		btnCorrect.addActionListener(this);
		add(btnCorrect);
		
		
		btnMatched = new JButton();
		btnMatched.setBorderPainted(false);
		btnMatched.setIcon(new MatchedIcon());
		btnMatched.addActionListener(this);
		add(btnMatched);
		
		
		btnWrong = new JButton();
		btnWrong.setBorderPainted(false);
		btnWrong.setIcon(new WrongIcon());
		btnWrong.addActionListener(this);
		add(btnWrong);
		
		btnRestart = new JButton("Reset");
		btnRestart.addActionListener(this);
		add(btnRestart);
		
		btnUndo = new JButton("Undo");
		btnUndo.addActionListener(this);
		add(btnUndo);
		
		btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(CheatsPanel.this, "Author: MaomiHz\nTwitter: @MaomiHz\nHFLS Developer Team", "About", JOptionPane.INFORMATION_MESSAGE);
				CheatsPanel.this.requestFocus();
			}
		});
		add(btnAbout);
		
	}
	
	
	public CheatsPanel() {
		setBackground(Color.orange);
		setLayout(new GridLayout(11,6));
		setup();
		addKeyListener(this);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	// make a move with type
	private void addResult(int type) {
		switch (type) {
		case Pattern.CORRECT:
			labelsList.get(currentIndex).setIcon(new CorrectIcon());
			patternList[currentIndex % 4] = Pattern.CORRECT;
			break;
		case Pattern.MATCHED:
			labelsList.get(currentIndex).setIcon(new MatchedIcon());
			patternList[currentIndex % 4] = Pattern.MATCHED;
			break;
		case Pattern.WRONG:
			labelsList.get(currentIndex).setIcon(new WrongIcon());
			patternList[currentIndex % 4] = Pattern.WRONG;
			break;
		default:
		}
		currentIndex++;
		
		// Make a guess
		if (currentIndex % 4 == 0) {
			Guess theGuess = new Guess(currentGuess, new Pattern(patternList));
			g.makeGuess(theGuess);
			guessHistory.add(theGuess);
			if (g.getRemain() <= 1) {
				if (g.getRemain() == 0) {
					JOptionPane.showMessageDialog(this, "Hey, I'm confused! There must be something wrong!", "I can't...", JOptionPane.WARNING_MESSAGE);
					setup();
					return;
				}
				JOptionPane.showMessageDialog(this, "Correct Answer is: " + g.getNextGuess() + ", Game will restart...","I win!!!", JOptionPane.INFORMATION_MESSAGE);
				setup();
				return;
			}
			currentGuess = g.getNextGuess();
			numLabelsList.get(currentIndex / 4).setText(currentGuess.toString());
		}
	}
	
	//undo a move
	private void undo() {
		if (currentIndex % 4 > 0) {
			patternList[currentIndex % 4] = 0;
			labelsList.get(currentIndex - 1).setIcon(null);
			currentIndex--;
		} else if (currentIndex != 0) {
			g.revert(1);
			Guess prevGuess = guessHistory.remove(guessHistory.size() - 1);
			currentGuess = prevGuess.getComb();
			patternList = prevGuess.getPtn().toArray();
			patternList[currentIndex % 4] = 0;
			labelsList.get(currentIndex - 1).setIcon(null);
			numLabelsList.get(currentIndex / 4).setText(null);
			currentIndex--;
		}
	}
	
	
	//Key Listener
	public void keyPressed(KeyEvent event) {
		switch(event.getKeyCode()) {
		case KeyEvent.VK_Q:
		case KeyEvent.VK_A:
		case KeyEvent.VK_Z:
			addResult(Pattern.CORRECT);
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_S:
		case KeyEvent.VK_X:
			addResult(Pattern.MATCHED);
			break;
		case KeyEvent.VK_E:
		case KeyEvent.VK_D:
		case KeyEvent.VK_C:
			addResult(Pattern.WRONG);
			break;
		case KeyEvent.VK_BACK_SPACE:
			undo();
			break;
		default:
		}
	}
	public void keyReleased(KeyEvent event) {
		
	}
	public void keyTyped(KeyEvent event) {

	}
	
	//Action Listener
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton)(event.getSource());
		if (source == btnCorrect) {
			addResult(Pattern.CORRECT);
		} else if (source == btnMatched) {
			addResult(Pattern.MATCHED);
		} else if (source == btnWrong) {
			addResult(Pattern.WRONG);
		} else if (source == btnRestart) {
			setup();
		} else if (source == btnUndo) {
			undo();
		}
		
		requestFocus();
	}
}
