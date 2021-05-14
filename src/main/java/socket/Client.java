package socket;

import java.io.*;
import java.net.Socket;

/**
 * 聊天室客户端
 */
public class Client {
    /*
    java.net.Socket 套接字
    Socket封装了TCP协议的链接和通讯细节，使得我们可以很方便的与
    远端计算机建立链接，并基于两个流的读写操作完成与远端计算机额的数据交换，达到通讯的目的
     */

    private Socket socket;
   //构造方法，用来初始化客户端
    public Client() {
        try {
            socket = new Socket("localhost",7806);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //客户端开始工作的方法
    public void start(){
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw,true);
            pw.println("你好服务端");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
