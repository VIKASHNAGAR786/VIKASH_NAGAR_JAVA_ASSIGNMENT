// Question: Write a program to flatten a nested list of integers (example: [[1,2],[3,[4,5]]] -> [1,2,3,4,5]).
import java.util.*;

public class Q7 {
    public static void flatten(List<?> nested, List<Integer> result) {
        for (Object item : nested) {
            if (item instanceof List<?>) {
                flatten((List<?>) item, result);
            } else {
                result.add((Integer) item);
            }
        }
    }

    public static void main(String[] args) {
        List<Object> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, Arrays.asList(4, 5)));
        List<Integer> result = new ArrayList<>();
        flatten(nested, result);
        System.out.println(result);
    }
}
