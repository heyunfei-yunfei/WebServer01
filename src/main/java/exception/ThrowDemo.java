package exception;
/*
测试异常的抛出
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();
        /*
        当我们调用一个含有throws声明异常抛出的方法时，编译器要求
        我们必须处理这个异常，否则编译不通过，处理方式有两种
        1；使用try-catch捕获处理
        2；在当前方法上继续使用throws声明该异常的抛出
        具体使用哪种取决于异常处理的责任问题，但永远不应当在main方法上写throws
         */
        try {//满足语法，但是不满足业务的情况
            p.setAge(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("此人的年龄为"+p.getAge());
    }
}
