package week9;
import javax.swing.JFrame;
public class GameWindow extends JFrame {
	//没有对窗口进行初始化。
	public GameWindow() {
		this.setSize(500, 400);
		this.setLocation(200, 200);
		this.setVisible(true);
	}
	
	public GameWindow(int x, int y) {
		this.setSize(x, y);
		this.setLocation(200, 200);
		this.setVisible(true);
		System.out.println("这里是构造方法，这条语句会在对象产生的时候被调用");
	}
	
	//类中的代码块，称为构造代码块
	{
		int a = 55;
		System.out.println("这里是构造代码块，这条语句会在对象产生之前被调用");
	}
	//类中添加了static的代码块，称为静态代码块，它是在类加载的时候被调用的。
	static{
		int a = 55;
		System.out.println("静态代码块，它是在类加载的时候被调用的");
	}

	public static void main(String[] args) {
		GameWindow window = new GameWindow(200, 200);	
        System.out.println(window);	
	}
}
