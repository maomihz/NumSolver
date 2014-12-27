import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.event.*;


public class CheatsPanel extends JPanel implements ActionListener {
	
	private CheatedGame g;
	private ArrayList<JLabel> labelsList;
	private int currentIndex;
	private int[] patternList;
	private int patternIndex;
	private ArrayList<JLabel> numLabelsList;
	private int currentLabel;
	private Combination currentGuess;
	
	private JButton btnCorrect, btnMatched, btnWrong;
	private JButton btnRestart, btnRedo;
	
	private void setup() {
		removeAll();
		g = new CheatedGame();
		labelsList = new ArrayList<JLabel>();
		currentIndex = 0;
		patternList = new int[4];
		patternIndex = 0;
		numLabelsList = new ArrayList<JLabel>();
		currentLabel = 0;
		currentGuess = g.getNextGuess();
		
		for (int i=0;i<10;i++) {
			JButton btn = new JButton(String.valueOf(i+1));
			add(btn);
			JLabel label = new JLabel();
			label.setBackground(Color.green);
			label.setOpaque(true);
			add(label);
			numLabelsList.add(label);
			
			JLabel[] results = new JLabel[4];
			for (int a=0;a<4;a++) {
				results[a] = new JLabel();
				add(results[a]);
				labelsList.add(results[a]);
			}
		}
		
		numLabelsList.get(currentLabel).setText(currentGuess.toString());
		currentLabel++;
		
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
		
		btnRedo = new JButton("Undo");
		btnRestart.addActionListener(this);
		add(btnRedo);
		
	}
	
	
	public CheatsPanel() {
		setBackground(Color.orange);
		setLayout(new GridLayout(11,6));
		
		setup();
		

	}
	
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton)(event.getSource());
		if (source == btnCorrect) {
			labelsList.get(currentIndex).setIcon(new CorrectIcon());
			currentIndex++;
			patternList[patternIndex] = Pattern.CORRECT;
			patternIndex++;
		} else if (source == btnMatched) {
			labelsList.get(currentIndex).setIcon(new MatchedIcon());
			currentIndex++;
			patternList[patternIndex] = Pattern.MATCHED;
			patternIndex++;
		} else if (source == btnWrong) {
			labelsList.get(currentIndex).setIcon(new WrongIcon());
			currentIndex++;
			patternList[patternIndex] = Pattern.WRONG;
			patternIndex++;
		} else if (source == btnRestart) {
			setup();
		}
		
		// Make a guess
		if (patternIndex == 4) {
			patternIndex = 0;
			g.makeGuess(new Guess(currentGuess, new Pattern(patternList)));
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
			numLabelsList.get(currentLabel).setText(currentGuess.toString());
			currentLabel++;

			
		}
		
	}
}
