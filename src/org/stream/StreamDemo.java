package org.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * tutorials: https://howtodoinjava.com/java-8-tutorial/
 *
 * @author Steven
 * @referto :<hrf>https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html</hrf>
 */
public class StreamDemo {

    private static List<Integer> normalList = new ArrayList<>();
    private static List<User> userList = new ArrayList<>();

    static {

        Collections.addAll(normalList, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.addAll(userList,
                new User("1", "steven", 18),
                new User("1", "steven", 19),
                new User("1", "peck", 20),
                new User("1", "james", 21),
                new User("1", "steven", 22),
                new User("1", "thor", 23),
                new User("1", "james", 24),
                new User("1", "steven", 25));

    }

    public static void main(String[] args) {

        userList.sort((s,s1)->s.getAge().compareTo(s1.getAge()));

        ArrayList<Integer> collect = normalList.stream().collect(Collectors.toCollection(ArrayList::new));

        List<Integer> collect2 = normalList.stream().distinct().collect(Collectors.toList());

        ArrayList<User> distinctList1 = userList.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingLong(User::getAge))), ArrayList::new
                        )
                );

        LinkedList<User> distinctList2 = userList.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getAge() + ";" + o.getName()))), LinkedList::new
                        )
                );


        // Convert elements to strings and concatenate them, separated by commas

        String collect1 = userList.stream().map(User::getName).collect(Collectors.joining(", "));

        // Accumulate names into a TreeSet
        Set<String> set = userList.stream().map(User::getName).collect(Collectors.toCollection(TreeSet::new));


        // Compute sum of salaries of employee
        int total = userList.stream()
                .collect(Collectors.summingInt(User::getAge));

        // Group employees by department
        Map<String, List<User>> byDept
                = userList.stream()
                .collect(Collectors.groupingBy(User::getName));

        // Compute sum of salaries by department
        Map<String, Integer> totalByDept
                = userList.stream()
                .collect(Collectors.groupingBy(User::getName,
                        Collectors.summingInt(User::getAge)));

        // Partition students into passing and failing
        Map<Boolean, List<User>> passingFailing =
                userList.stream().collect(Collectors.partitioningBy(s -> s.getAge() >= 19));

    }
}

class User {


    private String userId;
    private String name;
    private Integer age;

    public User() {
    }

    public User(String userId, String name, Integer age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}