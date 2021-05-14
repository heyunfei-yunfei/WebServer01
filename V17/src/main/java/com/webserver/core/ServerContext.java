package com.webserver.core;

import com.webserver.servlet.HttpServlet;
import com.webserver.servlet.LoginServlet;
import com.webserver.servlet.ReServlet;
import com.webserver.servlet.ShowAllUserServlet;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/*
该类保存所有服务端共用信息
 */
public class ServerContext {
    private static Map<String, HttpServlet> servletMapping = new HashMap<>();

    static {
        initServletMapping();
    }

    private static void initServletMapping(){

//        servletMapping.put("/myweb/regUser",new ReServlet());
//        servletMapping.put("/myweb/loginUser",new LoginServlet());
//        servletMapping.put("/myweb/showAllUser",new ShowAllUserServlet());
        /*
        通过解析config/servlets.xml文件初始化servletMapping
        实现：
        将servlet.xml文件中根标签下的所有<servlet>标签获取到，并将其中的属性：
        path的值作为key。class的值利用反射实例化对应的Servlet作为value并
        存取到servletMapping中完成初始化
        注：反射实例化后返回值是Object类型，需要造型为HttpServlet才能退存入Map中
         */
        try{
            SAXReader reader = new SAXReader();
            Document doc = reader.read("./config/servlets.xml");
            Element root = doc.getRootElement();
            List<Element> list = root.elements("servlet");
            for (Element e :list){
                String path = e.attributeValue("path");
                String className = e.attributeValue("className");
                Class cls = Class.forName(className);
                HttpServlet servlet = (HttpServlet)cls.newInstance();
                servletMapping.put(path,servlet);
            }
            System.out.println(servletMapping);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /*
    根据请求路径获取对应的Servlet
    path
     */
    public static HttpServlet getServlet(String path){
        return servletMapping.get(path);
    }


}
