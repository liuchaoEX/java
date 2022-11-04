package week9;

public class ChildClass extends FatherClass{
    //int age; String name
    //introduce()方法
    int age ;
    String name;
    public ChildClass(){
        age = 10;
        name = "Marry";
    }

    public void introduce(){
        System.out.println("这是");
    }
    //子类的构造方法不是父类直接获得的。
    //如果子类没有自定义构造方法，系统会默认的分配一个没有参数的构造方法给子类
    //在子类的构造方法中会默认的调用父类的没有参数的构造方法
}
