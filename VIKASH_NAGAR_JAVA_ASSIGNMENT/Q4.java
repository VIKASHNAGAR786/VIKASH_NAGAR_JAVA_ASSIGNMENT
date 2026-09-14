// Question: Write a program to find the k most frequently occurring elements in a given array.
import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int number : numbers) {
            if (frequencies.containsKey(number)) {
                frequencies.put(number, frequencies.get(number) + 1);
            } else {
                frequencies.put(number, 1);
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(frequencies::get));
        for (int number : frequencies.keySet()) {
            heap.offer(number);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> result = new ArrayList<>(heap);
        result.sort(Comparator.comparingInt(frequencies::get).reversed());
        System.out.println(result);
    }
}