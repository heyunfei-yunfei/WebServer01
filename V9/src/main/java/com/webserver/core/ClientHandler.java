package com.webserver.core;

import com.webserver.http.EmptyRequestException;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 每个客户端连接后都会启动一个线程来完成与该客户端的交互
 * 交互过程遵循HTTP协议的一问一答要求，分三步进行处理
 * 1：解析请求
 * 2：处理请求
 * 3：响应客户端
 */
public class ClientHandler implements  Runnable{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            HttpRequest request = new HttpRequest(socket);
            HttpResponse response = new  HttpResponse(socket);

            //2 处理请求
            String path = request.getUri();
            File file = new File("./webapps"+path);


            /**
             * 判断用户请求的资源是否存在并且还要求定位的是文件
             */
            if (file.exists()&&file.isFile()){
                response.setEntity(file);

                /**
                如何根据用户请求的资源文件（file对象表示的文件）；来设置
                Content-Type对应的值？
                提示：要根据用户请求的资源文件的后缀来设置这个值，参考http.txt
                文件最后提供的6种
                 */
                Map<String,String> mimeMapping = new HashMap<>();
                mimeMapping.put("html","text/html");
                mimeMapping.put("css","text/css");
                mimeMapping.put("js","application/javascript");
                mimeMapping.put("jpg","image/jpeg");
                mimeMapping.put("png","image/png");
                mimeMapping.put("gif"," image/gif");
                //logo.png
                //获取到文件名中最后一个点之后第一个字符的位置
                int index = file.getName().lastIndexOf(".")+1;
                //截取文件后缀名
                String ext = file.getName().substring(index);
                String mime = mimeMapping.get(ext);
                response.putHeaders("Content-Type",mime);
                response.putHeaders("Content-Length",file.length()+"");

            }else{
               File notFoundPage = new File("./webapps/root/404.html");
               response.setStatusCode(404);
               response.setStatusReason("NotFound");
               response.setEntity(notFoundPage);
               response.putHeaders("Content-Type","text/html");
               response.putHeaders("Content-Length",notFoundPage.length()+"");

            }
            //3 响应客户端
            response.flush();
            /*
            发送一个标准的HTTP响应，将刚才写好的页面：
            .webapps/myweb/index.html

            相应的格式
            HTTP/1.1 200 OK(CRLF)
            Content-Type: text/html(CRLF)
            Content-Length: 2546(CRLF)(CRLF)
            1011101010101010101......
             */

            OutputStream out = socket.getOutputStream();
            //1发送状态行

            //2发送响应头


            //发送响应正文

            System.out.println("响应发送完毕");


           //单独捕获空请求异常，不需要做任何出路，目的仅是忽略处理工作
        }catch (EmptyRequestException e){

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //最终交互完毕后与客户端断开连接
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




