package planWar4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    //接受被显示物
    LinkedList<Display> disList;
    PlayerPlane playerPlane;
    int width,height;
    Image bgImage;
    //背景图片坐标
    int bgX,bgY;
    //背景图片速度
    int bgSpeed;
    
    //初始化游戏面板
    public GamePanel(){
        this.width = 600;
        this.height = 800;
        this.bgSpeed = 2;
        bgImage = Toolkit.getDefaultToolkit().getImage("Java\\images\\bgImg.jpg");
        this.setBackground(Color.white);
        this.setSize(500,500);
        //提供给自适应窗口的大小
        this.setPreferredSize(new Dimension(this.width,this.height));
    }

    //让游戏面板的背景图片移动
    public void bgMove(){
        this.bgY += this.bgSpeed;
        if(this.bgY >=this.height)
            this.bgY = 0;
    }
    //重写一个从父类继承的方法paint，这个方法负责面板的绘制
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        g.drawOval(0,0,width,height);
        //画第一张图片
        g.drawImage(bgImage,bgX,bgY- this.height,width,height,this);
        //画第二张图片
        g.drawImage(bgImage,bgX,bgY,width,height,this);
        //绘制玩家飞机
        //this.playerPlane.paint(g);
        //被显示列表的所有元素绘制出来
        if(this.disList.size() != 0){
            for(int i =0;i<this.disList.size();i++){
                this.disList.get(i).paint(g);
                if(this.disList.get(i) instanceof AbstractEnemy){
                    System.out.println("paint");
                }
            }

            //如果游戏暂停，游戏界面提示“游戏暂停，按空格继续”

            //如果游戏结束，游戏界面提示“游戏结束，按空格再来一局”
        }
    }

}
