package exception;
/*
finally块
finally是异常处理机制的最后一块，即：可以直接跟在try之后或者最后一个
catch之后
finally块可以保证只要程序执行到try语句块中，无论try语句块中的代码是否
抛出异常，finally都必定执行
我们可以将释放资源等操作放在finally中确保执行。

 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        System.out.println("程序结束了");

    }
}
