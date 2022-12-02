package planWar4;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.LinkedList;

public class PlayerPlane implements Display{
    //定义数据
    int x,y;
    int width,height;
    Image image;
    int lifeValue;
    int speed;
    int fireSort;
    //添加一个开火的状态
    boolean isFire = true;
    //为玩家飞机加上子弹集合
    LinkedList<AbstractBullet> bulletList = new LinkedList<AbstractBullet>();
  

    //构造方法进行初始化
    public PlayerPlane(){
        this.x = 200;
        this.y = 200;
        this.image = Toolkit.getDefaultToolkit().getImage("Java\\images\\myPlane.png");
        this.width = 80;
        this.height = 80;
        
    }


    //定义方法
    public void move(){

    }
    public void fire(){
        
    }
    public void eatTools(){
        
    }
    public void paint(Graphics g){
        g.drawImage(image, x, y, null);
    }

}
