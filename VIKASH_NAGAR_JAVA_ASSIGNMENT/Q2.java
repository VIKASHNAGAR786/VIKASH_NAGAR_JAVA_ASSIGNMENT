// Question: Write a program that counts how many times each word appears in a sentence.
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        String sentence = "Java is fun, and Java is powerful.";
        String[] words = sentence.toLowerCase().split("\\W+");
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }

        System.out.println(counts);
    }
}