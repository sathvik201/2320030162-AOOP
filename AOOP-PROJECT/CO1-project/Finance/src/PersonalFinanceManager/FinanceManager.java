package PersonalFinanceManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    private List<Transaction> transactions = new ArrayList<>();
    private final String filePath = "transactions.dat";

    public FinanceManager() {
        loadTransactions();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        saveTransactions();
    }

    public void editTransaction(int id, String type, double amount, String description) {
        transactions.stream()
            .filter(transaction -> transaction.getId() == id)
            .findFirst()
            .ifPresent(transaction -> {
                transaction.setType(type);
                transaction.setAmount(amount);
                transaction.setDescription(description);
                saveTransactions();
            });
    }

    public void deleteTransaction(int id) {
        transactions.removeIf(transaction -> transaction.getId() == id);
        saveTransactions();
    }

    public List<Transaction> listTransactions() {
        return transactions;
    }

    public double getTotalIncome() {
        return transactions.stream()
            .filter(transaction -> transaction.getType().equalsIgnoreCase("income"))
            .mapToDouble(Transaction::getAmount)
            .sum();
    }

    public double getTotalExpense() {
        return transactions.stream()
            .filter(transaction -> transaction.getType().equalsIgnoreCase("expense"))
            .mapToDouble(Transaction::getAmount)
            .sum();
    }

    public double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    private void saveTransactions() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(transactions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadTransactions() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            transactions = (List<Transaction>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
