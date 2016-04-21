import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import javax.swing.Icon;


public class MatchedIcon implements Icon {
	private int size;
	public MatchedIcon() {
		this(25);
	}
	public MatchedIcon(int size) {
		if (size >= 4) {
			this.size = size;
		} else {
			this.size = 4;
		}
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.drawOval(x+2, y+2, size-4, size-4);

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
