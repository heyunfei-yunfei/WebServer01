package io;

import java.io.*;
import java.util.Scanner;

/**
 * 使用留链接创建PrintWriter
 *
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
//        FileOutputStream fos = new FileOutputStream("ds");
//        OutputStreamWriter ost = new OutputStreamWriter(fos);
//        BufferedWriter bw = new BufferedWriter(ost);
//        PrintWriter pw = new PrintWriter(bw);
//        pw.println("dlkasjdf");
//        pw.println("dlkasjdf");
//        System.out.println("写出完毕");
//        pw.close();

        /**
         * 程序启动后要求用户数入文件名，然后对文件进行写操作
         * 之后用户输入的每行字符串都按行写入到文件中
         * 当用户单独输入exit时程序退出
         * 要去：自行组建留链接
         */



        /*
        在流链接中创建PrintWreter时，如果第一个参数指定要链接的流后，可以在传入一个boolean值参数，如果这个值为true，
        则打开了PrintWriter的自动行刷新工能
        即：每当我们调用println方法后就会自动flush
        注意：调用println方法后并不会flush！
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入文件名");
        String filename = scan.nextLine();
        FileOutputStream fos = new FileOutputStream("filename");
        OutputStreamWriter ost = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(ost);
        PrintWriter pw = new PrintWriter(bw,true);





        System.out.println("请输入内容");
        while (true){
            String line = scan.nextLine();
            if ("exit".equals(line)){
                break;
            }
        pw.println(line);
        }








    }
}
