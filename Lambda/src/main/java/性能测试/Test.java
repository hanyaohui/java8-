package 性能测试;

import java.util.*;

/**
 * 获取list中最大值测试
 *
 * 结果: 非stream性能最好, 并行stream次之, stream最差
 * */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            list.add(random.nextInt(Integer.MAX_VALUE));
        }

        iteratorTest(list);
        forTest(list);
        strongForTest(list);
        streamTest(list);
        parallelStreamTest(list);
    }

    // 1.通过迭代器遍历
    public static void iteratorTest(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        Iterator<Integer> iterator = list.iterator();
        int max = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            int cur = iterator.next();
            if (cur > max) {
                max = cur;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("iterator：" + (endTime - startTime) + "ms");
    }

    // 2.普通for循环遍历
    public static void forTest(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            if (cur > max) {
                max = cur;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("普通for：" + (endTime - startTime) + "ms");
    }

    // 3.增强for循环遍历
    public static void strongForTest(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        int max = Integer.MIN_VALUE;
        for (int cur : list) {
            if (cur > max) {
                max = cur;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("增强for：" + (endTime - startTime) + "ms");
    }

    // 4.stream循环遍历
    public static void streamTest(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        Optional max = list.stream().max(Integer::compare);
        //System.out.println(max.get());

        long endTime = System.currentTimeMillis();
        System.out.println("stream：" + (endTime - startTime) + "ms");
    }

    // 5.并行stream循环遍历
    public static void parallelStreamTest(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        Optional max = list.parallelStream().max(Integer::compare);

        long endTime = System.currentTimeMillis();
        System.out.println("并行stream：" + (endTime - startTime) + "ms");
    }
}
