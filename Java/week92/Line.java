package week92;

import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape {
	Point p1, p2;
	
	public Line(int x1 , int y1 , int x2, int y2) {
		p1 = new Point(x1, y1);
		p2 = new Point(x2, y2);		
	}

	@Override
	public void paint(Graphics g) {
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
		
	}

}
