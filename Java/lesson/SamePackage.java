package lesson;

public class SamePackage {
    //尝试使用DataClass中定义的4个变量，观察结果

    public void method(){
        //产生DataClass对象，然后用该类的对象去调用里面的变量
        DataClass dataClass = new DataClass();
        System.out.println(dataClass.a);
        System.out.println(dataClass.b);
        System.out.println(dataClass.c);
        //d变量的访问权限是private的私有，只能在定义它的类DataClass中使用，其它类使用不了
        //System.out.println(dataClass.d);  因为访问权限，所以出错

    }
}
