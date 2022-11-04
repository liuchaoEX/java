package week9;

public class FatherClass {
    //变量
    int age ;
    String name ;
    //构造方法
    public FatherClass(){
        age = 40;
        name = "Peter"; 
    }
    

    public FatherClass(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }


    //方法
    public void introduce(){
        System.out.println("My name is " + name + ",I am " + age + " years old.");
    }
}
