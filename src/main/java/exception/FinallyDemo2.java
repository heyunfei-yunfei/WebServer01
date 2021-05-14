package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 异常处理机制在io中的使用
 */
public class FinallyDemo2 {
    public static void main(String[] args) {
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream("skdj");
            fos.write(1);
           // fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
