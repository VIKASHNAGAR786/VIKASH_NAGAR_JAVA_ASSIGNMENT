// Question: Write a program to find the first unique number in a stream of numbers (you can only traverse once).
import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        int[] stream = {4, 5, 1, 2, 1, 4, 5};
        Map<Integer, Integer> counts = new LinkedHashMap<>();

        for (int number : stream) {
            if (counts.containsKey(number)) {
                counts.put(number, counts.get(number) + 1);
            } else {
                counts.put(number, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First unique number: " + entry.getKey());
                return;
            }
        }

        System.out.println("No unique number");
    }
}