package thread;

/**
 * 使用匿名内部类完成两种线程的创建方式
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                for (int i=0;i<1000;i++){
                    System.out.println("卓彩虹");
                }

            }
        };



        Runnable r2 =()->{
            for (int i=0;i<1000;i++){
                    System.out.println("卓彩虹");
                }
        };
        Thread t2 =new Thread(r2);

        t1.start();
        t2.start();
    }
}
