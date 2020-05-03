import lambdaservice.Hello;
import lambdaservice.impl.HelloImpl;

import java.util.function.Predicate;

public class ServiceTest {

    public static void main(String[] args) {
        HelloImpl impl = new HelloImpl();
        impl.hello(); // 常规方法
        impl.nice();  // 默认方法
        Hello.good(); // 静态方法
        System.out.println("--------------------------");

        // 通过lambda表达式实现函数式接口的方法
        Hello lambdaHello = () -> {
            System.out.println("lambdaHello");
        };
        lambdaHello.hello();
        System.out.println("--------------------------");

        // 执行jdk1.8内部的函数式接口
        Predicate<String> predicate = (String string) -> {
            return "predicate".equals(string);
        };
        System.out.println(predicate.test(null));
        System.out.println(predicate.test("predicate"));
    }
}
