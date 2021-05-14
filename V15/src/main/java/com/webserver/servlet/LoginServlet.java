package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LoginServlet {
    public void service(HttpRequest request, HttpResponse response){
        System.out.println("LoginServlet:开始登录");
        //1获取登录信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2处理登录
         if (username==null||password==null){
             response.setEntity(new File("./webapps/myweb/login_fail.html"));
             return;
         }
        try(
                RandomAccessFile raf = new RandomAccessFile("user.dat","r");
        ){

            for(int i=0;i<raf.length()/100;i++){
                //现将指针移动到该条记录的开始位置
                raf.seek(i*100);
                byte[] data = new byte[32];
                raf.read(data);
                String name = new String(data,"UTF-8").trim();
                if(name.equals(username)){
                    raf.read(data);
                    String pwd = new String(data,"UTF-8").trim();
                    if(pwd.equals(password)){
                        response.setEntity(new File("./webapps/myweb/login_success.html"));
                        return;
                    }
                    //执行到这里说明用户名对了，但是密码不对
                    break;//停止停止读取工作，因为没有重复记录
                }
            }
            //设置
            response.setEntity(new File("./webapps/myweb/login_fail.html"));

        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("LoginServlet:处理登录完毕!");
    }
}
