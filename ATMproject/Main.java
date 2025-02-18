package ATMproject;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AtmOperationInterf op = new AtmOperationImpl();

        int atmnumber = 123;
        int atmpin = 123;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To ATM Machine !");
        System.out.print("Enter ATM number : ");
        int atmNumber = sc.nextInt();
        System.out.print("Enter ATM Pin : ");
        int atmPin = sc.nextInt();
        if ((atmnumber == atmNumber) && (atmpin == atmPin)) {
            // System.out.print("Validation done!");
            while (true) {
                System.out.println(
                        "1.View available balance\n2.Withdraw amount\n3.Deposit amount\n4.View Mini statements\n5.Exit");
                System.out.println("Enter your choice : ");
                int ch = sc.nextInt();
                if (ch == 1) {
                    op.viewBalance();
                } else if (ch == 2) {
                    System.out.println("Enter Amount to withdraw : ");
                    double withdrawAmount = sc.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                } else if (ch == 3) {
                    System.out.println("Enter Amount to Deposit : ");
                    double depositAmount = sc.nextDouble();// 5000
                    op.depositAmount(depositAmount);
                } else if (ch == 4) {
                    op.viewMiniStatements();
                } else if (ch == 5) {
                    System.out.println("Collect Atm card \nThank you for using atm machine");
                    System.exit(0);
                } else {
                    System.out.println("please Enter valid choice.");
                }
            }
        } else {
            System.out.println("Incorrect Atm number and pin .");
            System.exit(0);
        }
    }
}
