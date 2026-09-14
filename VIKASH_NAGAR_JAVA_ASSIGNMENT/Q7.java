import java.util.*;

public class Q7 {
    public static List<Integer> flatten(List<?> nested) {
        List<Integer> result = new ArrayList<>();
        for (Object item : nested) {
            if (item instanceof List<?>) {
                result.addAll(flatten((List<?>) item));
            } else if (item instanceof Integer) {
                result.add((Integer) item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Object> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, Arrays.asList(4, 5)));
        System.out.println(flatten(nested));
    }
}