package thread;

/**
 * java中所有的代码都是靠线程运行的，main方法也不例外。
 * 当java进程启动后，虚拟机会创建一条线程来执行main方法，并且这条线程
 * 的名字也叫“main”，我们称它为“主线程”
 * 线程提供了一个静态方法：
 * static Thread currentThread()
 * 该方法可以获取运行这个方法的线程
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println("主线程"+main);
        dosome();
    }
    public static void dosome(){
        Thread T = Thread.currentThread();
        System.out.println("运行dosome方法的线程是："+T);
    }

}
