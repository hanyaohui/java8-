package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi2 {

    // 定义字符串list
    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("郎朗");
        list.add("贝多芬");
        list.add("贝多芬");
        list.add("马克西姆");
        list.add("柴可夫斯基");
        list.add("理查德·克莱德曼");
        return list;
    }

    // 1.map()：为中间操作, 接受Functional接口(按照统一规则修改数据)
    public void mapTest() {
        List<String> list = this.getList();
        list = list.stream().map(i -> "音乐家：" + i).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    // 2.filter()：条件过滤 (有状态中间操作)
    public void filterTest() {
        List<String> list = this.getList();
        list = list.stream().filter(i -> i.length() > 3).
                             filter(i -> i.contains("克")).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    // 3.peek()：迭代数据完成数据的多次处理
    public void peekTest() {
        List<String> list = this.getList();
        list = list.stream().filter(i -> i.contains("克")).collect(Collectors.toList());
        list.stream().peek(i -> System.out.println("音乐家: " + i)).
                      peek(i -> System.out.println("钢琴家: " + i)).
                      forEach(System.out::println);
    }

    // 4.skip(n)：跳过前n个数据 (有状态中间操作)
    public void skipTest() {
        List<String> list = this.getList();
        list.stream().skip(2).forEach(System.out::println);
    }

    // 5.limit(n)：保留前n个数据 (有状态中间操作)
    public void limitTest() {
        List<String> list = this.getList();
        list.stream().skip(2).limit(2).forEach(System.out::println);
    }

    // 6.distinct()：去除重复数据 (有状态中间操作)
    public void distinctTest() {
        List<String> list = this.getList();
        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * 7.数字类型相关操作
     *
     * ① sorted: 排序 (有状态中间操作)
     * ② max: 获取最大值
     * ③ min: 获取最小值
     * ④ reduce: 求和
     * */
    public void integerTest() {
        List<Integer> list = new ArrayList<>();
        list.add(3); list.add(5); list.add(1); list.add(0);

        list.stream().sorted().forEach(System.out::println);

        System.out.println("----------------------");

        Optional max = list.stream().max((x, y) -> x - y);
        System.out.println("最大值: " + max.get());

        Optional min = list.stream().min((x, y) -> x - y);
        System.out.println("最小值: " + min.get());

        Optional total = list.stream().reduce((sum, i) -> sum + i);
        System.out.println("求和: " + total.get());
    }

    public static void main(String[] args) {
        StreamApi2 api = new StreamApi2();
        //api.mapTest();
        //api.filterTest();
        //api.peekTest();
        //api.skipTest();
        //api.limitTest();
        //api.distinctTest();
        api.integerTest();
    }
}
