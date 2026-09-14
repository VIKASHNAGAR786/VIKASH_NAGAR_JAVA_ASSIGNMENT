// Question: Write a program to sort a list of students by marks (descending). If marks are equal, sort by name.
import java.util.*;

public class Q9 {
    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return name + " - " + marks;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Ravi", 85),
                new Student("Anita", 92),
                new Student("Amit", 92),
                new Student("Neha", 78)));

        students.sort((student1, student2) -> {
            if (student1.marks != student2.marks) {
                return student2.marks - student1.marks;
            }
            return student1.name.compareTo(student2.name);
        });

        students.forEach(System.out::println);
    }
}