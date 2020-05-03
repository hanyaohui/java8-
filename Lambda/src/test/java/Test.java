public class Test {

    public static void main(String[] args) {

        String b = new StringBuilder("hello").append("World1").toString();
        System.out.println(b == b.intern());

        String a = new StringBuilder("hel").append("loWorld1").toString();
        System.out.println(b == a.intern());
        System.out.println(a == a.intern());
    }
}
