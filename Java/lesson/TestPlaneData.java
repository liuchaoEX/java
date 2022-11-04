package lesson;

public class TestPlaneData {
    public static void main(String[] args) {
        //通过
        Plane plane = new Plane();
        //System.out.println(plane.x);语句出错，提示不可见，所以封装的

        //通过提供getters方法是否可以读取封装的数据
        System.out.println("(" +plane.getX() + " , " + plane.getY() +")");

        //通过提供的setter方法，来修改被封存了的数据
        System.out.println("speed = " + plane.getSpeed());
        //修改
        plane.setSpeed(50);
        //修改后，显示修改的结果
        System.out.println("speed = " + plane.getSpeed());
    }
}
