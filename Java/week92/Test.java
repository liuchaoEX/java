package week92;

public class Test {

	public static void main(String[] args) {
		Window window = new Window();
		//Rectangle rectangle = new Rectangle(100, 100, 200, 80);
		//window.setShape(rectangle);
		Line line = new Line(50,50, 550,550);
		window.setShape(line);
	}
}
