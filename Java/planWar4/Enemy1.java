package planWar4;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;
import java.awt.Image;

public class Enemy1 extends AbstractEnemy{
    //构造方法初始化这种敌机
    public Enemy1(){
        this.image = Toolkit.getDefaultToolkit().getImage("Java\\images\\enemy1.png");
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        //一个随机的横坐标
        this.x = new Random().nextInt(600 - this.width);
        this.y = -this.height;
        this.lifeValue = 2;
        this.hurtValue = 1;
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        y += 3;
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(image, this.x, this.y, null);
    }
    
}
