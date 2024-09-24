package PersonalFinanceManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Transaction");
            System.out.println("2. Edit Transaction");
            System.out.println("3. Delete Transaction");
            System.out.println("4. List Transactions");
            System.out.println("5. Show Financial Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Type (income/expense): ");
                    String type = scanner.next();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter Description: ");
                    String description = scanner.next();
                    manager.addTransaction(new Transaction(id, type, amount, description));
                    break;
                case 2:
                    System.out.print("Enter ID to Edit: ");
                    id = scanner.nextInt();
                    System.out.print("Enter New Type (income/expense): ");
                    type = scanner.next();
                    System.out.print("Enter New Amount: ");
                    amount = scanner.nextDouble();
                    System.out.print("Enter New Description: ");
                    description = scanner.next();
                    manager.editTransaction(id, type, amount, description);
                    break;
                case 3:
                    System.out.print("Enter ID to Delete: ");
                    id = scanner.nextInt();
                    manager.deleteTransaction(id);
                    break;
                case 4:
                    manager.listTransactions().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Total Income: " + manager.getTotalIncome());
                    System.out.println("Total Expense: " + manager.getTotalExpense());
                    System.out.println("Net Balance: " + manager.getNetBalance());
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
