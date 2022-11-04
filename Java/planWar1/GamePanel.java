package planWar1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    PlayerPlane playerPlane;
    int width,height;
    Image bgImage;
    //初始化游戏面板
    public GamePanel(){
        this.width = 600;
        this.height = 800;
        bgImage = Toolkit.getDefaultToolkit().getImage("Java\\images\\bgImg.jpg");
        this.setBackground(Color.GREEN);
        this.setSize(500,500);
        //提供给自适应窗口的大小
        this.setPreferredSize(new Dimension(this.width,this.height));
    }


    //重写一个从父类继承的方法paint，这个方法负责面板的绘制
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        g.drawOval(0,0,width,height);
        g.drawImage(bgImage,0,0,width,height,this);
        //绘制玩家飞机
        this.playerPlane.paint(g);
    }

}
