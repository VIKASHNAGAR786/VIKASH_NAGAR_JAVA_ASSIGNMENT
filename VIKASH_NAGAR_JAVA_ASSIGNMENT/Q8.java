// Question: Given a list of transactions (userId, amount), write a program to find the user who spent the maximum total amount.
import java.util.*;

public class Q8 {
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

        Map<String, Double> totalSpent = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (totalSpent.containsKey(transaction.userId)) {
                double oldAmount = totalSpent.get(transaction.userId);
                totalSpent.put(transaction.userId, oldAmount + transaction.amount);
            } else {
                totalSpent.put(transaction.userId, transaction.amount);
            }
        }

        String highestUser = "No transactions";
        double highestAmount = 0;
        for (String userId : totalSpent.keySet()) {
            if (totalSpent.get(userId) > highestAmount) {
                highestAmount = totalSpent.get(userId);
                highestUser = userId;
            }
        }

        System.out.println(highestUser);
    }
}