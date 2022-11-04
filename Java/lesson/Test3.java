package lesson;

import java.util.Arrays;
public class Test3{
    public static void main(String[] args){
    //对比基本数据类型的变量和引用数据类型的数组，在赋值过程中的区别
    int a = 5;
    int b = a;  //基本数据类型的值传递
    //输出赋值后2个变量的值
    System.out.println("赋值后，b=" + b + ", a= " + a);

    int array1[] = {2,4,6,8,10};
    int array2[] = array1;      //引用数据类型的值传递
    //传递赋值后两个数组的值
    System.out.println("赋值后，array2中的元素为：");
    for(int ele : array2){
        System.out.println(ele + " ,  ");
    }
    System.out.println();
    System.out.println("赋值后，array1中的元素为：");
    for(int ele : array1){
        System.out.println(ele + " ,  ");
    }
    System.out.println();
    //修改b中的数据，看是否影响a
    b++;
    System.out.println("修改后，b=" + b +", a= "+ a);

    //修改array2中的元素，将元素都修改成99，看是否影响array1数组的元素

    Arrays.fill(array2,99);
    //显示array2数组
    System.out.println("赋值后，array2中的元素为：");
    for(int ele : array2){
        System.out.println(ele + " ,  ");
    }
    System.out.println();
    //显示array1数组
    System.out.println("赋值后，array1中的元素为：");
    for(int ele : array1){
        System.out.println(ele + " ,  ");
    }
    System.out.println();
    }
}