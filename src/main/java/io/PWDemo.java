package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲字符流
 * java.io.BufferedWriter和BufferedReader
 * 缓冲字符流内部有一个缓冲区，读写文本数据会被统一转换为读写保证效率
 * 并且可以按行读写文本数据。
 * java.io,PrintWriter具有自动行刷新功能的缓冲字节流，内部总是链接
 * BufferedWriter最为缓冲功能，这各流更常用
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter("raf.txt","utf-8");
        pw.println("sdfjasdlfjalskdjf");
        System.out.println("写出完毕");
        pw.close();
    }
}
