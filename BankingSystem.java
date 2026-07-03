import java.util.Scanner;

// User-defined Exception for Minimum Balance
class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String message) {
        super(message);
    }
}

// User-defined Exception for Invalid Menu Choice
class InvalidChoiceException extends Exception {
    public InvalidChoiceException(String message) {
        super(message);
    }
}

// User-defined Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double openingBalance) throws MinimumBalanceException {
        if (openingBalance < 1000) {
            throw new MinimumBalanceException("Opening balance must be at least Rs.1000.");
        }
        balance = openingBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Rs." + amount + " deposited successfully.");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        balance -= amount;
        System.out.println("Rs." + amount + " withdrawn successfully.");
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Opening Balance: ");
            double openingBalance = sc.nextDouble();

            BankAccount account = new BankAccount(openingBalance);

            while (true) {
                System.out.println("\n===== BANK MENU =====");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter Deposit Amount: ");
                            double dep = sc.nextDouble();
                            account.deposit(dep);
                            break;

                        case 2:
                            System.out.print("Enter Withdraw Amount: ");
                            double wd = sc.nextDouble();
                            account.withdraw(wd);
                            break;

                        case 3:
                            account.checkBalance();
                            break;

                        case 4:
                            System.out.println("Thank You!");
                            sc.close();
                            return;

                        default:
                            throw new InvalidChoiceException("Invalid Menu Choice!");
                    }
                } catch (InvalidChoiceException | InsufficientBalanceException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }

        } catch (MinimumBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}