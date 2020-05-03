// 内部类的this关键字
public class ThisTest {

    String s1 = "全局变量";

    // 传统内部类
    public void traditionInner() {
        String  s2 = "局部变量";

        new Thread(new Runnable() {
            String  s3 = "私有变量";
            @Override
            public void run() {
                s1 = "s1";
                System.out.println(s1);
                s3 = "s3";
                System.out.println(this.s3); // this只表示当前内部类
                //s2 = "s2"; // 报错: 不能对局部变量进行修改, 默认推导变量修饰符为final
            }
        }).start();
    }

    // lambda内部类
    public void lambdaInner() {
        String  s2 = "局部变量"; // 默认修饰符为final

        new Thread(() -> {
            this.s1 = "s1"; // this表示所属方法所在对象: 当前类
            System.out.println(this.s1);
            //s2 = "s2"; // 报错: 依然不能对局部变量进行修改, 默认推导变量修饰符为final
        }).start();
    }


    public static void main(String[] args) {
        ThisTest test = new ThisTest();
        //test.traditionInner();
        test.lambdaInner();
    }
}
