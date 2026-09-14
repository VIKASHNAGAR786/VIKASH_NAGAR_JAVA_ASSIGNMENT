// Question: Write a program that removes duplicates from a list while maintaining original order.
import java.util.*;

public class Q1 {
    public static <T> List<T> removeDuplicates(List<T> values) {
        return new ArrayList<>(new LinkedHashSet<>(values));
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(4, 2, 4, 1, 2, 3, 1);
        System.out.println(removeDuplicates(values));
    }
}