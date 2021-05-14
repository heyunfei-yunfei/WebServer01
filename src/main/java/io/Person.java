package io;

import java.io.Serializable;
import java.util.Arrays;

/*
用当前类测试对象流的duixiangduxiecaozuo

当一个类的实例希望被对象输出时，该类必须实现Serializable接口
这个接口没有任何抽象方法，他成为“签名接口”，是编译器敏感的一个接口
当一个类实现了这个接口时，编译器则认为它的实例希望被序列化，因此在编译为class问件事会添加一个方法，用于将当前对象转换为一组字节，对象输出流
就是基于这个方法将对象转换为一组字节后写出的
 */
public class Person implements Serializable {
    private String  name;
    private int age;
    private String gender;
    /*
    当一个属性被transient修饰后，那么对象在序列化时会忽略这个
    属性的值
    忽略不必要的属性可以达到对象瘦身的目的，减少资源开销。
     */
    private transient String[] otherInfo;

    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }
}
