package planWar4;

import java.awt.Image;

public abstract class AbstractEnemy implements Enemy{
    //在这个抽象类中，有一些所有种类敌机共有的数据变量
    int x, y;
    int width , height;
    Image image;
    int lifeValue;
    int hurtValue;
}
