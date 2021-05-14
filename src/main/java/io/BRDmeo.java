package io;

import java.io.*;

/**
 * 使用缓冲字符输入流读取文本数据
 */
public class BRDmeo {
    public static void main(String[] args) throws IOException {
         /*
    将当前源代码输出到控制台
     */
        FileInputStream fis = new FileInputStream("./src/main/java/io/BRDemo.");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line ;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
        br.close();

    }



}
