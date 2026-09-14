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

    public static void sortStudents(List<Student> students) {
        students.sort(Comparator.comparingInt((Student student) -> student.marks)
                .reversed()
                .thenComparing(student -> student.name));
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Ravi", 85),
                new Student("Anita", 92),
                new Student("Amit", 92),
                new Student("Neha", 78)));
        sortStudents(students);
        students.forEach(System.out::println);
    }
}