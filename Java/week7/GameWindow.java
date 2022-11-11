package week7;
import java.awt.Graphics;
import javax.swing.JFrame;
//提供游戏的界面
public class GameWindow extends JFrame{
    //有一个Plane 成员变量(实例变量)
    Plane plane;
    
    public void setPlane(Plane plane) {
        this.plane = plane;
    }
    //游戏窗口需要通过构造方法进行对象的初始化
    public GameWindow(){
        this.setSize(500,500);
        this.setTitle("飞机大战");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //让游戏窗口把飞机画出来，需要一个在窗口画画的功能
    //游戏窗口继承于JFrame,JFrame的父类Window提供了一个paint()方法，可以用来绘制窗口
    //重写paint()方法
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        plane.painSelf(g,this);
    }
}
