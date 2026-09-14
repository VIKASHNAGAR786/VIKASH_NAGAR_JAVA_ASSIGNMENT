import java.util.*;

public class Q4 {
    public static List<Integer> topKFrequent(int[] numbers, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : numbers) {
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
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
        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
    }
}