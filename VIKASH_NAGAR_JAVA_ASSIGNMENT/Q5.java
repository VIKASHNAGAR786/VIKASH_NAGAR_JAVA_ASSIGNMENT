import java.util.*;

public class Q5 {
    public static OptionalInt firstUnique(int[] stream) {
        Map<Integer, Integer> counts = new LinkedHashMap<>();
        for (int number : stream) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return OptionalInt.of(entry.getKey());
            }
        }
        return OptionalInt.empty();
    }

    public static void main(String[] args) {
        OptionalInt result = firstUnique(new int[] { 4, 5, 1, 2, 1, 4, 5 });
        System.out.println(result.isPresent() ? result.getAsInt() : "No unique number");
    }
}