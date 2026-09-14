import java.util.*;

public class Q2 {
    public static Map<String, Integer> countWords(String sentence) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : sentence.toLowerCase().split("\\W+")) {
            if (!word.isEmpty()) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(countWords("Java is fun, and Java is powerful."));
    }
}