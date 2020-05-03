// 方法重载测试：同方法, 同参数类型, 不能用lambda, 推荐内部类实现
public class OverloadTest {

    // 定义两个同名方法
    public void method(Interface1 interface1) {
        interface1.test();
    }
    public void method(Interface2 interface2) {
        interface2.test();
    }

    // lambda不支持, 会报错, 虚拟机自动推导函数类型混淆
    public void lambdaInner() {
        //method(() -> {
        //
        //});
    }

    // 传统匿名内部类调用
    public void traditionInner() {
        method(new Interface1() {
            @Override
            public void test() {
                System.out.println("Interface1");
            }
        });
        method(new Interface2() {
            @Override
            public void test() {
                System.out.println("Interface2");
            }
        });
    }
}

interface Interface1{
    void test();
}

interface Interface2{
    void test();
}
