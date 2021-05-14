package thread;

/**
 * sleep方法要求必须处理中断异常InterruptedException
 * 当一个线程调用该方法处于睡眠阻塞的过程中，其中断方法interrupt（）被调用
 * 时，此时该线程的睡眠阻塞会被中断，sleep方法就会抛出中断异常
 */
public class SleepDemo2 {
}
