import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("    WELCOME TO ATM SYSTEM");
        System.out.println("================================");

        int atmPin = 1234;

System.out.print("Enter your ATM PIN: ");
int enteredPin = sc.nextInt();

if(enteredPin == atmPin) {
    System.out.println("PIN Verified Successfully!");
}
else {
    System.out.println("Incorrect PIN! Access Denied.");
    sc.close();
    return;
}

String[] history = new String[20];
int transactionCount = 0;

double balance = 10000;
int choice;

while(true) {

    System.out.println("1. Check Balance");
    System.out.println("2. Deposit Money");
    System.out.println("3. Withdraw Money");
    System.out.println("4. Transaction History");
    System.out.println("5. Exit");

    System.out.print("Enter your choice: ");
    choice = sc.nextInt();

    if(choice == 1) {
        System.out.println("Current Balance: ₹" + balance);
    }

    else if(choice == 2) {

    System.out.print("Enter amount to deposit: ₹");
    double deposit = sc.nextDouble();

    if(deposit > 0) {
        balance = balance + deposit;

        history[transactionCount] = "Deposited: ₹" + deposit;
        transactionCount++;

        System.out.println("Deposit Successful!");
        System.out.println("Updated Balance: ₹" + balance);
    }
    else {
        System.out.println("Invalid amount!");
    }
}

    else if(choice == 3) {

    System.out.print("Enter amount to withdraw: ₹");
    double withdraw = sc.nextDouble();

    if(withdraw <= 0) {
        System.out.println("Invalid amount!");
    }

    else if(withdraw > balance) {
        System.out.println("Insufficient Balance!");
    }

    else {
        balance = balance - withdraw;

        history[transactionCount] = "Withdrawn: ₹" + withdraw;
        transactionCount++;

        System.out.println("Withdrawal Successful!");
        System.out.println("Remaining Balance: ₹" + balance);
    }
}
else if(choice == 4) {

    System.out.println("\n===== TRANSACTION HISTORY =====");

    if(transactionCount == 0) {
        System.out.println("No transactions found.");
    }

    else {
        for(int i = 0; i < transactionCount; i++) {
            System.out.println((i + 1) + ". " + history[i]);
        }
    }
}

    else if(choice == 5) {
    System.out.println("\n===== ATM SESSION SUMMARY =====");
    System.out.println("Final Balance: ₹" + balance);
    System.out.println("Thank you for using ATM System!");
    break;
}

    else {
        System.out.println("Invalid Choice! Please try again.");
    }
}
    }
}