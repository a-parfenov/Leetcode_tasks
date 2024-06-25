package ru.parfenov.leetcode.interviews;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
class User {
    private String userName;
    private Integer age;
    private List<Group> groups;

    public User(String userName, Integer age, List<Group> groups) {
        this.userName = userName;
        this.age = age;
        this.groups = groups;
    }
}

@Data
class Group {
    private String name;
    private String description;

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

public class SomeConsumer {
    public static void main(String[] args) {
        List<Group> groups = List.of(new Group("X-Men", "Superhero team"), new Group("Avengers", "Superhero team"));
        List<Group> groups2 = List.of(new Group("Men", "Superhero team"), new Group("Avengers", "Superhero team"));
        User user1 = new User("Alice", 30, groups);
        User user2 = new User("Nike", 22, groups2);

        List<User> userList = List.of(user1, user2);
        SomeConsumer consumer = new SomeConsumer();
        List<User> filteredUsers = consumer.consume(userList.stream());

        System.out.println(filteredUsers); // Выведет [User(userName=Alice, age=30, groups=[Group(name=X-Men, description=Superhero team)])]
    }

    public List<User> consume(Stream<User> userStream) {
        return userStream
                .filter(user -> user.getGroups().stream()
                        .anyMatch(group -> group.getName().startsWith("X")))
                .toList();
    }

}
