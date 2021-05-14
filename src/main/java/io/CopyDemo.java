package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 通过提高每次读写的数据量，减少实际读写的次数可以提高读写效率
 *
 * 单字节读写是随机读写形式。
 * 一组字节的读写是块读写形式
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {

            RandomAccessFile raf = new RandomAccessFile("raf","r");
            RandomAccessFile desc = new RandomAccessFile("raf","r");
       /*
       int read(byte[] data)
       一次性从文件中读取给定的字节数组总长度的字节量并存入到该数组中
       ，返回值为实际读取到的字节量
        */
        int len;
        byte[] data = new byte[1024*10];
        long start = System.currentTimeMillis();
        while((len = raf.read(data))!=-1){
                desc.write(data,0,len);
        }
        long  end = System.currentTimeMillis();
        System.out.println("复制完成");
        raf.close();
        desc.close();


    }
}
