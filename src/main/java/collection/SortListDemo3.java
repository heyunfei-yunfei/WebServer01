package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*当元素已经实现了Comparable接口，但是该比较规则不满足
* 我们排序需求时，也可以用重载的sort方法排序*/
public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("niubi");

        Collections.sort(list,(String s1,String s2)->s1.length()-s2.length());
        System.out.println();


    }
}
