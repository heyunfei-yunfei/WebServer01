package io;

import java.io.FileInputStream;
import java.io.IOException;

public class FisDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("raf.txt");
        byte[] data = new byte[1000];
       int len = fis.read(data);

       /*
       String提供了的重载构造器
       String(byte[]data,int offset ,int len ,String csn)
       将给定的字节数组从下标offset出开始的连续len个字节按照指定的字符集转换为字符串
        */
        String str = new String(data,0,len,"utf-8");
        System.out.println(str);
        System.out.println(str.length());

        fis.close();




    }
}
