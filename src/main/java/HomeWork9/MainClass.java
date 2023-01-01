package HomeWork9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", Arrays.asList(
                new Course("Java"),
                new Course("English"))));
        students.add(new Student("Vanya", Arrays.asList(
                new Course("Java"),
                new Course("English"),
                new Course("Java1"))));
        students.add(new Student("Adil", Arrays.asList(
                new Course("Java"),
                new Course("Java1"))));
        students.add(new Student("S", Arrays.asList(
                new Course("Java"))));

        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .map(c -> c.getCourseName())
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        Course course = new Course("English");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList())
        );
    }
}
