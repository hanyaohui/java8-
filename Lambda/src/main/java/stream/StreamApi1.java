package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi1 {

    // 获取Stream对象的方法
    public void getStream() {
        // 多个数据转换Stream对象
        Stream<String> stringStream = Stream.of("张三", "李四", "朱六");

        // 数组获取Stream对象
        String[] array = new String[]{"aaa", "bbb", "ccc"};
        Stream arrayStream = Arrays.stream(array);

        // list获取Stream对象
        List list = new ArrayList(); list.add(1);
        Stream listStream = list.stream();

        // set获取Stream对象
        Set set = new HashSet(); set.add("s1");
        Stream setStream = set.stream();

        // set获取Stream对象
        Map<String, Integer> map = new HashMap<>(); map.put("张三", 3);
        Stream mapStream = map.entrySet().stream();
    }

    // Stream转换为指定类型
    public void streamChangeType() {
        Stream stream = Stream.of("张三", "李四", "朱六");

        // 转为数组 [一旦执行完成, Stream就会关闭, 下一个操作执行时会报错]
        String[] strings = (String[]) stream.toArray(String[]::new);
        System.out.println(strings.toString());

        // 拼接成一个字符串 [上个操作执行完成, Stream已经关闭, 这个操作执行时会报错]
        String appendString = stream.collect(Collectors.joining()).toString();
        System.out.println(appendString);

        // 转为list
        List list = (List) stream.collect(Collectors.toList());
        System.out.println(list);

        // 转为set
        Set set = (Set) stream.collect(Collectors.toSet());
        System.out.println(set);

        // 转为map
        Map map = (Map) stream.collect(Collectors.toMap(k->k, v->v));
        System.out.println(map);
    }

    // IntStream操作
    public void intStream() {
        System.out.println("of遍历: ");
        IntStream.of(new int[]{0, 1, 2}).forEach(System.out::println);

        System.out.println("range遍历: ");
        IntStream.range(0, 5).forEach(System.out::println);

        System.out.println("rangeClosed遍历: ");
        IntStream.rangeClosed(0, 5).forEach(System.out::println);
    }

    public static void main(String[] args) {
        StreamApi1 streamApi = new StreamApi1();
        streamApi.streamChangeType();
        //streamApi.intStream();
    }
}
