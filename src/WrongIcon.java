import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;


public class WrongIcon implements Icon {
	private int size;
	public WrongIcon() {
		this(25);
	}
	public WrongIcon(int size) {
		this.size = size;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.drawOval(x,y,size, size);
		g.drawLine(x+size, y, x, y+size);

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
