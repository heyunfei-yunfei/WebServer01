package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//聊天室服务端
public class Server {
    /*
    java.net.ServerSocket是运行在服务端的，如果我们把Socket
    比喻为“电话”，那么ServerSocket则比喻为“总机”
    ServerSocket主要有两个工作
    1：向服务端的小左系统申请服务端口，客户端就是通过这个端口与
    ServerSocket建立家里连接的
    2;监听服务端口，一旦一个客户端尝试建立链接，此时会立即创建一个
    Socket（相当于接电话），然后通过这个Socket就可以与建立连接的客户端交互了
     */
    private ServerSocket serverSocket;
   public Server(){
       try {
           System.out.println("正在启动服务端");
           /*
           创建ServerSocket 是要指定服务端口，该端口不能与系统
           中其他程序的端口冲突，否则会抛出异常
           java.net.BindException:address already in use
            */
           serverSocket = new ServerSocket(7806);
           System.out.println("服务端启动");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public void start(){
       try {
           /*
           ServerSocket提供的方法
           Socket accept()
           该方法是一个阻塞方法，调用后程序“卡住”，直到一个客户端
           与服务端建立连接，此时accept方法会立即返回一个Socket
           通过这个Socket就可以和该客户端交互了
           多次调用这个方法就可以与让多个客户端键连接。
            */

           while (true){
               System.out.println("等待客户端连接。。。");
               Socket socket = serverSocket.accept();
               System.out.println("一个客户端连接了！");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread t = new Thread(clientHandler);
                t.start();


           }


       } catch (IOException e) {
           e.printStackTrace();
       }


   }

    public static void main(String[] args) {
       Server server = new Server();
       server.start();

    }
    //该线程任务是负责与指定的客户端进行交互
    private class ClientHandler implements Runnable{
       private Socket socket;
       private String host;
       public ClientHandler(Socket socket){
           this.socket=socket;
           //通过socket获取客户端的IP地址的字符串格式
           host = socket.getInetAddress().getHostAddress();
       }

       public void run(){
        try{
             /*
           InputStream getInputStream()
           通过Socket的这个方法可以获取一个字节输入流，读取的就是
           远端计算机额发送过来的数据
            */

            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine())!=null){
                System.out.println(host+"说："+line);
            }
        }catch (IOException e){
         //   e.printStackTrace();
        }finally {
            try {
            //当客户端断开要进行的相关处理
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
       }
    }


}
