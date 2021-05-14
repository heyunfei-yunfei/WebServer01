package collection;

import java.awt.*;
import java.util.*;
import java.util.List;

//排序自定义元素
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(3,5));
        list.add(new Point(8,10));
        list.add(new Point(12,17));
        list.add(new Point(1,1));
        list.add(new Point(2,6));
        list.add(new Point(3,3));
        System.out.println(list);
        /*
        该sort方法要求集合元素必须实现Comparable接口
        否则编译不通过
        乳沟这个sort方法不能直接使用就不使用这个方法了，因为他会让我们的代码产生了侵入性
        侵入性：当我们调用这个方法功能时，该方法要求我们还要其
        修改其它地方的代码时就是侵入性，改的越多侵入性越强。
        侵入性不利于代码的后期维护
         */
        /*Collections.sort(list)*/



        Collections.sort(list,new Comparator<Point>() {
            /*
            * 重载的sort方法允许我们临时传入一个比较器作为元素的比较规则
            * 此时我们可以再排序时通过匿名内部类形式创建一个比较器，为集合元素排序提供比较规则
            *实现Comparator接口后要重写方法compare，该方法就是用来定义两个元素之间的大小关系，
            * 返回值：
            * 当返回值>0时，表示o1>o2
            * 当返回值<0时，表示o1<o2
            *当返回值相等时，表示o1=o2
            * */
            public int compare(Point o1, Point o2) {
                int len1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
                int len2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();

                return len1-len2;
            }
        });
        System.out.println(list);

    }
}

