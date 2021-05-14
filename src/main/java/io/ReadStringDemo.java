package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
从文件中读取文本数据
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("note.txt", "r");
        for (int i=0;i<raf.length();i++) {
            byte[] data = new byte[(int) raf.length()];
            raf.read(data);
            String str = new String(data, "utf-8");




            System.out.println(str);
            raf.close();
        }
    }

}
