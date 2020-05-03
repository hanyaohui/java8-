package stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ForListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // 传统for循环遍历: 底层是迭代器Iterator遍历
        for (Integer integer : list) {
            System.out.println("for: " + integer);
        }

        // Iterator遍历
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator: " + iterator.next());
        }

        System.out.println("=====================");
        /**---------------------------------------**/

        // stream遍历
        List streamList = list.stream().collect(Collectors.toList());
        System.out.println(streamList);
        // 结合lambda过滤筛选
        List streamList1 = list.stream().filter(i -> i > 2).collect(Collectors.toList());
        System.out.println(streamList1);
    }
}
