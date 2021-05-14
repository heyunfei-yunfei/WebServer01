package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

//向文件中写入文本数据（字符串）
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new  RandomAccessFile("raf.txt","rw");
        /*
        String 提供了将当前字符串转换为一组自己饿的方法：
        byte[] getBytes(String csn)
        参数指定的字符集的名字，常用的：utf-8
        当字符集名字制定错误时，会抛出如下异常：不支持的字符集异常
        UnsupportedEncodingException:UFT-8
         */
        String str = "我爱你，爱着你，就像老鼠爱大米";
        byte[] data = str.getBytes("utf-8");
        raf.write(data);
        System.out.println("写出完毕");
        raf.close();


        System.out.println("请输入一个文件名");
        Scanner scanner = new Scanner(System.in);
        String sec = scanner.nextLine();
        RandomAccessFile randomAccessFile = new RandomAccessFile("sec","rw");
        while (true){
            String line = scanner.nextLine();
            if("exits".equals(line)){
                break;
            }
            byte[] arr = line.getBytes("utf-8");
            randomAccessFile.write(arr);
        }
        System.out.println("再见");
        randomAccessFile.close();













    }
}
