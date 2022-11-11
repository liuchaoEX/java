package week92;

import java.awt.Graphics;

public class Rectangle extends Shape{
	
	int x, y;
	int width, height;
	
	
	public Rectangle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}	
		
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	

	public int getPerimeter() {
		return (width + height) * 2;
	}
	
	
	public int getArea() {
		return width * height;
	}
	
	
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
	}	

}
