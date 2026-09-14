// Question: Write a program to rearrange characters in a string so that no two same characters are adjacent (use PriorityQueue).
import java.util.*;

public class Q6 {
    static class CharacterCount {
        char character;
        int count;

        CharacterCount(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String text = "aaabbc";
        Map<Character, Integer> counts = new HashMap<>();

        for (char character : text.toCharArray()) {
            if (counts.containsKey(character)) {
                counts.put(character, counts.get(character) + 1);
            } else {
                counts.put(character, 1);
            }
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

        if (result.length() == text.length()) {
            System.out.println(result);
        } else {
            System.out.println("Not possible");
        }
    }
}