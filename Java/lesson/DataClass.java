package lesson;

public class DataClass {
    //在这个类中定义的不停访问权限的一些文章
    public int a = 5;
    protected int b = 66;
    int c = 777;
    private int d = 8888;
    public void method(){
        //在类本身使用类中定义的变量，各种权限的变量
        System.out.println("a = " + a);
        System.out.println("a = " + b);
        System.out.println("a = " + c);
        System.out.println("a = " + d);

    }
}
