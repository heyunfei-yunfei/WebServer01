package io;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
使用转换流读取文本
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        //byte[] data = new byte[1000];

        int d;
        while (( d = isr.read())!=-1) {
            System.out.println((char) d);
        }
        isr.close();

    }
}
