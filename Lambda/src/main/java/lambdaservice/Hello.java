package lambdaservice;

@FunctionalInterface // 函数式接口定义, 接口只允许有一个常规方法
public interface Hello {

    void hello();

    // 允许默认方法存在-default
    default void nice() {
        System.out.println("nice");
    };

    // 允许静态方法存在-static
    static void good() {
        System.out.println("good");
    };

    // 允许继承自Object的方法
    String toString();
}
