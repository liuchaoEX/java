package planWar3;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class SimpleBullet implements Bullet{
    int x,y;
    int width,height;
    Image image;
    int hurtValue;
    //子弹移动一步的距离
    int step;

    //构造方法，进行初始化
    public SimpleBullet(int x,int y){
        this.x = x;
        this.y = y;
        image = Toolkit.getDefaultToolkit().getImage("Java\\images\\bullet.png");
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.hurtValue = 1;
        this.step = 3;
    }
    @Override
    public void move() {
        // TODO Auto-generated method stub
        this.y = this.y - this.step;
    }

    @Override
    public void hurt() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(image, x, y, null);
    }
    
}
