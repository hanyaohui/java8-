import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 方法引用测试
// 虽然代码简化, 但实际开发中考虑可读性
public class CollectionSortTest {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "mike"));
        list.add(new User(2, "linda"));
        list.add(new User(0, "lana"));

        // 传统内部类排序
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(list);

        /**------------------------------------**/

        // lambda排序
        Collections.sort(list, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(list);

        // 静态方法排序
        Collections.sort(list, User::staticCompareByAge);
        System.out.println(list);

        // 实例方法排序
        User user = new User();
        Collections.sort(list, user::compareByAge);
        System.out.println(list);
    }

}

class User {
    private Integer age;
    private String name;

    public User() {

    };

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    // 静态排序比较方法
    public static Integer staticCompareByAge(User user1, User user2) {
        return user1.getAge() - user2.getAge();
    }
    // 非静态排序比较方法
    public Integer compareByAge(User user1, User user2) {
        return user1.getAge() - user2.getAge();
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
