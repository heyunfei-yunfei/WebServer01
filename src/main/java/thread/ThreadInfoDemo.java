package thread;
/*
获取线程相关信息的方法
 */
public class ThreadInfoDemo {
    public static void main(String[] args) {
        //获取主线程
        Thread main = Thread.currentThread();
        String name = main.getName();
        System.out.println("name:"+name);

        long id = main.getId();
        System.out.println("id"+id);
        //获取现成的优先级
        int priority = main.getPriority();
        System.out.println("优先级："+priority);
        //线程是否还活着
        boolean i =main.isAlive();
        //线程是否为守护线程
        boolean isDaemon = main.isDaemon();
        //线程是否被中断了
        Boolean isInterrupted = main.isInterrupted();

    }
}
