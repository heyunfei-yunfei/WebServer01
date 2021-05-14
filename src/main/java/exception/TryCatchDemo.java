package exception;
/*
异常处理机制
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        /*
        当JVM执行某句代码出现了一个异常时，就会实例化这个异常的
        实例来表示这种问题，并将程序的执行过程设置进去以便追查错误
        出现的位置
        然后将该异常抛出。
         */
        try {
            System.out.println("程序开始了");
            String str = null;
                 /*
            try语句块中出现序偶物的语句之后的内容都不会执行
             */
            System.out.println(str.length());
            //try语句块中没有异常发生时，catch不会执行。

            //catch可以写多个，针对try中不同的异常可以分别捕获并处理
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
