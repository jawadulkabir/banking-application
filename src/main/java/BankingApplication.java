package main.java;

import main.java.Account.Account;
import main.java.AccountCreator.AccountCreator;
import main.java.AccountCreator.CurrentAccountCreator;
import main.java.AccountCreator.SalaryAccountCreator;
import main.java.AccountCreator.SavingsAccountCreator;

import java.util.Date;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Bank bank = Bank.getBankInstance();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n\nChoose an option:");
            System.out.println("1. Create a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Update an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Deposit an amount into your account");
            System.out.println("6. Withdraw an amount from your account");
            System.out.println("7. Search for an account");
            System.out.println("8. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Choose Account Type:");
                    System.out.println("Type 'C' to Create a new Current Account");
                    System.out.println("Type 'Sv' Create a new Saving Account");
                    System.out.println("Type 'Sl' Create a new Salary Account");
                    String accType = scanner.nextLine();

                    AccountCreator creator;
                    if(accType.equals("C"))
                    {
                        creator = new CurrentAccountCreator(1000);
                    }
                    else if(accType.equals("Sv"))
                    {
                        creator = new SavingsAccountCreator(2000);
                    }
                    else if(accType.equals("Sl"))
                    {
                        creator = new SalaryAccountCreator(200);
                    }
                    else
                    {
                        System.out.println("Invalid Choice");
                        continue;
                    }

                    System.out.println("Enter account name:");
                    String accName = scanner.nextLine();
                    System.out.println("Enter opening balance:");
                    double openingBalance = scanner.nextDouble();

                    bank.addAccount(creator, accName, openingBalance);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

        } while (choice != 8);

        scanner.close();
    }
}
