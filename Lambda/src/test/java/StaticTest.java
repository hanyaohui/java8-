/**
 * 静态语句块只能访问到定义在语句块之前的变量，它之后的变量不能访问，但可以赋值
 * */
public class StaticTest {

    static int a;

    static {
        System.out.println(a);

        //System.out.println(b); // 报错：静态语句块只能访问到定义在语句块之前的变量

        b = 2; // 静态语句块之后的变量可以赋值
    }

    static int b = 5;
}
