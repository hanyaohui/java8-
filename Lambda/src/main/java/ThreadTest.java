public class ThreadTest {

    public static void main(String[] args) {

        // 传统线程创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("传统线程创建");
            }
        }).start();

        // lambda线程创建, 简化结构
        new Thread(()->{
            System.out.println("lambda线程创建, 简化结构");
        }).start();
    }
}
