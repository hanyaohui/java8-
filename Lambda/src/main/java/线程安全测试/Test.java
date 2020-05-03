package 线程安全测试;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 并行stream线程安全测试
 *
 * 结果: 并行stream会存在数据丢失或报错
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        // 串行stream测试
        List<Integer> streamList = new ArrayList<>();
        list.stream().forEach((i) -> streamList.add(i));
        System.out.println("串行stream:" + streamList.size());

        // 并行stream测试(会存在数据丢失或报错)
        List<Integer> parallelStreamList = new ArrayList<>();
        list.parallelStream().forEach((i) -> parallelStreamList.add(i));
        System.out.println("并行stream:" + parallelStreamList.size());

        // 并行stream安全写法(collect()是线程安全的)
        List<Integer> safeParallelStreamList = list.parallelStream().collect(Collectors.toList());
        System.out.println("安全并行stream:" + safeParallelStreamList.size());
    }
}
