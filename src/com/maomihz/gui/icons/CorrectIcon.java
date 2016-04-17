package com.maomihz.gui.icons;
import java.awt.Component;
import java.awt.Graphics;

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
		g.fillOval(x, y, size, size);

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
