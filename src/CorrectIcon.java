import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;


public class CorrectIcon implements Icon {
	private int size;
	public CorrectIcon() {
		this(25);
	}
	public CorrectIcon(int size) {
		this.size = size;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND));
		g.fillOval(x+1, y+1, size-2, size-2);

	}

	@Override
	public int getIconWidth() {
		return size;
	}

	@Override
	public int getIconHeight() {
		return size;
	}

}
