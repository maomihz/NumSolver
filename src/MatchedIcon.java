import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;


public class MatchedIcon implements Icon {
	private int size;
	public MatchedIcon() {
		this(25);
	}
	public MatchedIcon(int size) {
		this.size = size;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.drawOval(x, y, size, size);

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
