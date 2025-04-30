import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

    public static void main(String[] args) {
        //JAVA SLOT MACHINE
        Scanner sc = new Scanner(System.in);
        int balance = 1000;
        int bet;
        int payout;
        String[] row;
        String playAgain;

        System.out.println("****************************");
        System.out.println("Welcome to Java Slots");
        System.out.println("Symbols: 🥚 🍔 🍿 🍞 🥓");
        System.out.println("****************************");

        while (balance > 0) {
            System.out.println("Current balance: रू." + balance);
            System.out.print("Place your bet amount: ");
            bet = sc.nextInt();
            sc.nextLine();

            if (bet > balance) {
                System.out.println("Insufficient Funds.");
                continue;
            } else if (bet <= 0) {
                System.out.println("Bet must be greater than 0");
                continue;

            } else {
                balance -= bet;
//                System.out.println("Current balance: रू." + balance);
            }

            System.out.println("Spinning...");
            row = spinRow();
            printRow(row);
            payout = getPayout(row, bet);
            if (payout > 0) {
                System.out.println("You won रू." + payout);
                balance += payout;
            } else {
                System.out.println("Sorry you lost this round!");
            }
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = sc.nextLine().toUpperCase();

            if (!playAgain.equals("Y")) {
                break;
            }
        }
        System.out.println("GAME OVER! Your final balance is रू."+balance);
        sc.close();
    }


    static String[] spinRow() {
        String[] symbols = {"🥚", "🍔", "🍿", "🍞", "🥓"};
        String[] row = new String[3]; //empty array which will be picked random
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }
        return row;
    }

    static void printRow(String[] row) {
        System.out.println("**************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("**************");
    }

    static int getPayout(String[] row, int bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch (row[0]) {
                case "🥚" -> bet * 3;
                case "🍔" -> bet * 4;
                case "🍿" -> bet * 5;
                case "🍞" -> bet * 10;
                case "🥓" -> bet * 20;
                default -> 0;
            };

        } else if (row[0].equals(row[1])) {
            return switch (row[0]) {
                case "🥚" -> bet * 2;
                case "🍔" -> bet * 3;
                case "🍿" -> bet * 4;
                case "🍞" -> bet * 5;
                case "🥓" -> bet * 10;
                default -> 0;
            };

        } else if (row[1].equals(row[2])) {
            return switch (row[1]) {
                case "🥚" -> bet * 2;
                case "🍔" -> bet * 3;
                case "🍿" -> bet * 4;
                case "🍞" -> bet * 5;
                case "🥓" -> bet * 10;
                default -> 0;
            };

        }
        return 0;

    }
}
