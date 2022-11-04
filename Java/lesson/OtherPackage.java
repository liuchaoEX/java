package lesson;

public class OtherPackage {
    //使用另外一个包中的类DataClass中定义的变量
    
    public void method(){
        DataClass dataClass = new DataClass();
        System.out.println(dataClass.a);
        //b的权限为protected，c的权限为缺省，它们都是在同一个包中的类才能使用的变量
        //当前的类和DataClass类不在同一个包中，就不能使用DataClass中的这种权限的变量。
        //下面的变量因为访问权限会出错
        // System.out.println(dataClass.b);
        // System.out.println(dataClass.c);
        // System.out.println(dataClass.d);
    }
}
