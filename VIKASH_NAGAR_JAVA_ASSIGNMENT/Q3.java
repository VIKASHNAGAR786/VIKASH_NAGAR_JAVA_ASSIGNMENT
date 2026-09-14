// Question: Write a program using HashMap to find two numbers that add up to target in O(n) time.
import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> seen = new HashMap<>();

        for (int index = 0; index < numbers.length; index++) {
            int complement = target - numbers[index];
            if (seen.containsKey(complement)) {
                System.out.println("Indexes: " + seen.get(complement) + ", " + index);
                return;
            }
            seen.put(numbers[index], index);
        }

        System.out.println("No two numbers found");
    }
}