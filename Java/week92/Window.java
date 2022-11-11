package week92;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Window extends JFrame{
	Shape shape;	
	
	
	public Window() {
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void paint(Graphics g ) {
		// TODO Auto-generated method stub
		super.paint(g);
		this.shape.paint(g);
	}

}
