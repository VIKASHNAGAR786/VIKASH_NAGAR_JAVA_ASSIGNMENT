// Question: Given a list of transactions (userId, amount), write a program to find the user who spent the maximum total amount.
import java.util.*;
import java.util.stream.Collectors;

public class Q8 {
    public static String highestSpender(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        transaction -> transaction.userId,
                        LinkedHashMap::new,
                        Collectors.summingDouble(transaction -> transaction.amount)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No transactions");
    }

    static class Transaction {
        String userId;
        double amount;

        Transaction(String userId, double amount) {
            this.userId = userId;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("U1", 120.50),
                new Transaction("U2", 300.00),
                new Transaction("U1", 200.00));
        System.out.println(highestSpender(transactions));
    }
}