package planWar4;

import java.awt.Image;

//定义一个抽象类，使得子弹列表中的所有子弹利用这种类型可以方便的调整子弹的坐标等信息
public  abstract class AbstractBullet  implements Bullet{
    int x,y;
    int width,height;
    Image image;
    int hurtValue;
    //子弹移动一步的距离
    int step;
}