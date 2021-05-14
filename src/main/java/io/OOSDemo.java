package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * java.io.ObjectOutStream和ObjectInputStream
 * 对象流是一对高级流，作用是方便我们读写java中任何类的实例（引用类型）
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        /*将对象Person对象写入文件person.obj中

         */
//        String name = "苍老师";
//        int age=18;
//        String gender = "女";
//        String[] otherInfo = {"是一名演员","台词较少","来自日本"};

        Person p = new Person("苍老师",18,"女", new String[]{"是一名演员", "台词较少", "来自日本"});
        System.out.println(p);
        FileOutputStream fos = new FileOutputStream("fos.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        /*
        对象输出流提供了写出对象的方法：
        void writeObjece(Objece obj)
        该方法会自动分析对像内容并将其转换为一组字节后写出，但是有一个
        前提条件，即：写出的对象必须实现了接口：java.io.Serializable
        否则会抛出如下异常；
        NotSerializableException

        对象经过对象输出流时：会将该对象按照其结构转换为一组字节
        这个过程称为：对象序列化

        序列化后的字节在经过文件输出流写入文件（写入磁盘）这个过程
        称为：数据持久化


         */
        oos.writeObject(p);
        System.out.println();
        oos.close();


    }
}
