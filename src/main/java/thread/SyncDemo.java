package thread;

/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一临界资源，由于线程切换时机不确定，导致操作顺序
 * 出现了混乱而产生错误。严重可能导致系统瘫痪
 *
 * 临界资源：操作该资源的整个过程同时只能被单个线程进行的资源。
 * 相当于多个人争抢一个东西导致的混乱
 */
public class SyncDemo {
    public static void main(String[] args) {
           Table table = new Table();
           Thread t1 = new Thread(){
               public void run(){
                   while (true){
                       int bean = table.getBean();
                       Thread.yield();
                       System.out.println(getName()+":"+bean);
                   }
               }
           };
        Thread t2 = new Thread(){
            public void run(){
                while (true){
                    int bean = table.getBean();
                    Thread.yield();

                    System.out.println(getName()+":"+bean);
                }
            }
        };
        t1.start();
        t2.start();
    }

}
class Table{
   private int beans = 20;
   public int getBean(){
       if(beans==0){
           throw new RuntimeException("豆子没有了");
       }
       //判断后，但beans还没有--操作前切换线程，会出现并发安全问题
       Thread.yield();//盖饭法让现代城主动让出CPU时间，模拟到这里没有时间了
       return beans--;
   }
}
