package main.java;

import main.java.accounts.Account;
import main.java.creators.AccountCreator;
import main.java.creators.CurrentAccountCreator;
import main.java.creators.SalaryAccountCreator;
import main.java.creators.SavingsAccountCreator;

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

            Account targetAccount;
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Choose Account Type:");
                    System.out.println("Type 'cur' to Create a new Current Account");
                    System.out.println("Type 'sav' Create a new Savings Account");
                    System.out.println("Type 'sal' Create a new Salary Account");
                    String accType = scanner.nextLine();

                    AccountCreator creator;
                    switch (accType) {
                        case "cur" -> creator = new CurrentAccountCreator();
                        case "sav" -> creator = new SavingsAccountCreator();
                        case "sal" -> creator = new SalaryAccountCreator();
                        default -> {
                            System.out.println("Invalid Choice");
                            continue;
                        }
                    }

                    System.out.println("Enter account name:");
                    String accName = scanner.nextLine();
                    System.out.println("Enter opening balance:");
                    String openingBalance = scanner.nextLine();

                    try{
                        bank.addAccount(creator, accName, Double.parseDouble(openingBalance));
                    }
                    catch (Exception ex)
                    {
                        System.err.println("Provide a valid opening balance");
                    }

                    break;

                case 2:
                    System.out.println("All accounts:");
                    bank.displayAllAccounts();
                    break;

                case 3:
                    System.out.println("Enter the Account No to update:");
                    String accNo = scanner.nextLine();
                    targetAccount = bank.searchAccount(accNo);

                    if(targetAccount != null)
                    {
                        System.out.println("Account Name: " + targetAccount.getAccountName() + ". Enter new name: ");
                        String newName = scanner.nextLine();
                        targetAccount.updateAccount(newName);
                    }
                    else
                    {
                        System.out.println("Account does not exist");
                    }
                    break;

                case 4:
                    System.out.println("Enter the account no to delete:");
                    String toDeleteAccNo = scanner.nextLine();

                    targetAccount = bank.searchAccount(toDeleteAccNo);
                    if(targetAccount != null)
                    {
                        targetAccount.delete();
                    }
                    else
                    {
                        System.out.println("Account does not exist");
                    }
                    break;

                case 5:
                    System.out.println("Enter the account no to deposit:");
                    String toDepositAccNo = scanner.nextLine();

                    targetAccount = bank.searchAccount(toDepositAccNo);
                    if(targetAccount != null)
                    {
                        System.out.println("Enter amount to deposit: ");
                        String amount = scanner.nextLine();
                        try{
                            targetAccount.depositAmount(Double.parseDouble(amount));
                        }
                        catch (Exception ex)
                        {
                            System.err.println("Provide a valid amount");
                        }
                    }
                    else
                    {
                        System.out.println("Account does not exist");
                    }
                    break;

                case 6:
                    System.out.println("Enter the account no to withdraw:");
                    String toWithdrawAccNo = scanner.nextLine();

                    targetAccount = bank.searchAccount(toWithdrawAccNo);
                    if(targetAccount != null)
                    {
                        System.out.println("Enter amount to withdraw: ");
                        String amount = scanner.nextLine();
                        try{
                            targetAccount.withdrawAmount(Double.parseDouble(amount));
                        }
                        catch (Exception ex)
                        {
                            System.err.println("Provide a valid amount");
                        }
                    }
                    else
                    {
                        System.out.println("Account does not exist");
                    }
                    break;

                case 7:
                    System.out.println("Enter the account no search:");
                    String toSearchAccNo = scanner.nextLine();

                    targetAccount = bank.searchAccount(toSearchAccNo);
                    if(targetAccount != null)
                    {
                        targetAccount.displayAccount();
                    }
                    else
                    {
                        System.out.println("Account does not exist");
                    }
                    break;

                case 8:
                    System.out.println("Exiting the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

        } while (choice != 8);

        scanner.close();
    }
}
