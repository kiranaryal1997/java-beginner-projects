import java.util.Scanner;

public class BankingProgram {
    static Scanner sc = new Scanner(System.in);

    public static void showBalance(double balance) {
        System.out.println("|------------------|");
        System.out.printf("NRS %.2f\n", balance);
        System.out.println("|------------------|");
    }

    public static double deposit() {
        double amount;
        System.out.print("Enter the amount to deposit: ");
        amount = sc.nextDouble();
        if (amount < 0) {
            System.out.println("Amount cannot be negative!");
            return 0;
        } else {
            return amount;
        }
    }

    public static double withdraw(double balance) {
        double amount;
        System.out.println("Enter amount to be withdrawn: ");
        amount = sc.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient Balance.");
            return 0;
        } else if (amount < 0) {
            System.out.println("Amount cannot be negative.");
            return 0;
        } else {
            return amount;
        }

    }

    public static void main(String[] args) {

        double balance = 0;
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            System.out.println("******************");
            System.out.println("BANKING PROGRAM");
            System.out.println("******************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("******************");

            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> balance += +deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("Invalid Choice!!");
            }
        }

        System.out.println("Thank you! Have a nice day.");
        sc.close();

    }
}