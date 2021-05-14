package exception;

import java.awt.*;
import java.io.IOException;

/*8
子类在重写超类含有throws声明异常抛出的方法时对throws的几种特殊的
重写规则
 */
public class ThrowsDemo {
    public void dosome ()throws IOException, AWTException{}
}
