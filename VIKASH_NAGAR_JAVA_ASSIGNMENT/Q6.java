import java.util.*;

public class Q6 {
    private static class CharacterCount {
        char character;
        int count;

        CharacterCount(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public static String rearrange(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char character : text.toCharArray()) {
            counts.put(character, counts.getOrDefault(character, 0) + 1);
        }

        PriorityQueue<CharacterCount> queue = new PriorityQueue<>(
                (first, second) -> Integer.compare(second.count, first.count));
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            queue.offer(new CharacterCount(entry.getKey(), entry.getValue()));
        }

        StringBuilder result = new StringBuilder();
        CharacterCount previous = null;
        while (!queue.isEmpty()) {
            CharacterCount current = queue.poll();
            result.append(current.character);
            current.count--;
            if (previous != null && previous.count > 0) {
                queue.offer(previous);
            }
            previous = current;
        }

        return result.length() == text.length() ? result.toString() : "Not possible";
    }

    public static void main(String[] args) {
        System.out.println(rearrange("aaabbc"));
    }
}