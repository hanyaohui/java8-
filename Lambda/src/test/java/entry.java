import java.util.*;

public class entry {

    public static void main(String[] args) {
        //Map<String, String> map = new HashMap<>();
        //map.put("a", "1");
        //map.put("b", "2");
        //Set<Map.Entry<String, String>> set = map.entrySet();
        //for (Map.Entry entry : set) {
        //    System.out.println(entry.getKey());
        //    System.out.println(entry.getValue());
        //}
        //System.out.println(map);
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.forEach((i) -> {
            System.out.println(i);
        });
    }
}
