// Question: Write a program that removes duplicates from a list while maintaining original order.
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 2, 4, 1, 2, 3, 1);
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        for (int number : numbers) {
            uniqueNumbers.add(number);
        }

        System.out.println(uniqueNumbers);
    }
}