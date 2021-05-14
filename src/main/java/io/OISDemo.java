package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象输入流
 *
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //将person.obj文件中的对象读取回来
        FileInputStream fis = new FileInputStream("person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person p = (Person)ois.readObject();
        System.out.println(p);
        ois.close();
    }
}
