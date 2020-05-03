public class BasicUsageTest {

    // lambda表达式基本用法测试
    public static void main(String[] args) {

        /** -----------------interfaceA---------------- **/

        // 1、无参数而且带大括号
        InterfaceA interfaceA = () -> {
            System.out.println("无参数&&带大括号");
        };
        interfaceA.test();

        // 2、如果只有一行执行代码, 可以省略大括号
        InterfaceA interfaceA1 = () -> System.out.println("一行代码省略大括号");
        interfaceA1.test();

        /** -----------------InterfaceB---------------- **/

        // 1、有参数; 有参数类型
        InterfaceB interfaceB = (Integer a, Integer b) -> {
            System.out.println(a + b);
        };
        interfaceB.test(1, 2);

        // 2、有参数; 无参数类型(会自动识别)
        InterfaceB interfaceB1 = (a, b) -> {
            System.out.println(a + b);
        };
        interfaceB1.test(3, 4);

        /** -----------------InterfaceC---------------- **/

        // 1、有返回值; 带大括号
        InterfaceC interfaceC = (a, b) -> {
            return a + b;
        };
        System.out.println(interfaceC.test(2, 2));

        // 2、有返回值; 只有一行执行代码, 可省略大括号
        InterfaceC interfaceC1 = (a, b) -> a + b;
        System.out.println(interfaceC1.test(3, 3));
    }

}

interface InterfaceA {
    void test();
}

interface InterfaceB {
    void test(Integer a, Integer b);
}

interface InterfaceC {
    Integer test(Integer a, Integer b);
}
