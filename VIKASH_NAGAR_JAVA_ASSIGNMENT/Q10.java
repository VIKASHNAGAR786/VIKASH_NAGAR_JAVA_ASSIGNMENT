// Question: Write a program that reads employee data from database, stores it in a List, and uses Streams + Comparator to find the 2nd highest paid employee.
import java.util.*;
import java.util.stream.*;

public class Q10 {
    static class Employee {
        int id;
        String name;
        double salary;

        Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return id + " - " + name + " - " + salary;
        }
    }

    public static Optional<Employee> secondHighestPaid(List<Employee> employees) {
        return employees.stream()
            .sorted((employee1, employee2) ->
                Double.compare(employee2.salary, employee1.salary))
                .skip(1)
                .findFirst();
    }

    public static void main(String[] args) {
        // In a real application, this List would be populated by a database query.
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Asha", 65000),
                new Employee(2, "Bharat", 90000),
                new Employee(3, "Charu", 78000));

        secondHighestPaid(employees).ifPresent(System.out::println);
    }
}