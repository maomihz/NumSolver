import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.event.*;


public class CheatsPanel extends JPanel {
	
	private CheatedGame g = new CheatedGame();
	private ArrayList<JLabel> labelsList = new ArrayList<JLabel>();
	private int currentIndex = 0;
	private int[] patternList = new int[4];
	private int patternIndex = 0;
	private ArrayList<JLabel> numLabelsList = new ArrayList<JLabel>();
	private int currentLabel = 0;
	private Combination currentGuess = g.getNextGuess();
	
	public CheatsPanel() {
		setBackground(Color.orange);
		setLayout(new GridLayout(11,6));
		
		
		for (int i=0;i<10;i++) {
			JButton btn = new JButton(String.valueOf(i+1));
			add(btn);
			JLabel label = new JLabel();
			label.setBackground(Color.green);
			label.setOpaque(true);
			label.setAlignmentX(CENTER_ALIGNMENT);
			label.setAlignmentY(CENTER_ALIGNMENT);
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
		
		JButton btn = new JButton();
		btn.setBorderPainted(false);
		btn.setIcon(new CorrectIcon());
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				labelsList.get(currentIndex).setIcon(new CorrectIcon());
				currentIndex++;
				patternList[patternIndex] = Pattern.CORRECT;
				patternIndex++;
				if (patternIndex == 4) {
					patternIndex = 0;
					g.makeGuess(new Guess(currentGuess, new Pattern(patternList)));
					currentGuess = g.getNextGuess();
					numLabelsList.get(currentLabel).setText(currentGuess.toString());
					currentLabel++;
				}
			}
		});
		add(btn);
		btn = new JButton();
		btn.setBorderPainted(false);
		btn.setIcon(new MatchedIcon());
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				labelsList.get(currentIndex).setIcon(new MatchedIcon());
				currentIndex++;
				patternList[patternIndex] = Pattern.MATCHED;
				patternIndex++;
				if (patternIndex == 4) {
					patternIndex = 0;
					g.makeGuess(new Guess(currentGuess, new Pattern(patternList)));
					currentGuess = g.getNextGuess();
					numLabelsList.get(currentLabel).setText(currentGuess.toString());
					currentLabel++;
				}
			}
		});
		add(btn);
		btn = new JButton();
		btn.setBorderPainted(false);
		btn.setIcon(new WrongIcon());
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				labelsList.get(currentIndex).setIcon(new WrongIcon());
				currentIndex++;
				patternList[patternIndex] = Pattern.WRONG;
				patternIndex++;
				if (patternIndex == 4) {
					patternIndex = 0;
					g.makeGuess(new Guess(currentGuess, new Pattern(patternList)));
					currentGuess = g.getNextGuess();
					numLabelsList.get(currentLabel).setText(currentGuess.toString());
					currentLabel++;
				}
			}
		});
		add(btn);
	}
}
