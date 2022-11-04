package week7;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
public class Plane {
    //定义数据
    int x,y;
    int width , height;
    Image image;  //引用数据类型没有赋初值，系统认为的值是null
    int speed;
    int bulletSort;
    int lifeVaue;

    //定义构造方法，是一类特殊的方法
    public Plane(){
        init();
    }

    public void init(){
        x = 200;
        y = 200;
        width = 80;
        height = 80;
        image = Toolkit.getDefaultToolkit().getImage("D:\\Code\\Java\\images\\myPlane.jpg");
        bulletSort = 1;
        lifeVaue = 10;
    }
    //定义方法，移动、开火、绘制自己、吃道具，死
    public void move(int x, int y){
        this.x = x;
        this.y = y;

    }
    public void fire(){
        
    }
    public void painSelf(Graphics g, JFrame ImageObserver){
        g.drawImage(image, x, y, width , height,ImageObserver);
    }
    public void eatTools(){
        
    }
    public void dead(){
        
    }
}
