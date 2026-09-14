// Question: Write a program using HashMap to find two numbers that add up to target in O(n) time.
import java.util.*;

public class Q3 {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
            int complement = target - numbers[index];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), index };
            }
            seen.put(numbers[index], index);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
    }
}