package main.java;

import main.java.Account.Account;
import main.java.AccountCreator.AccountCreator;
import main.java.AccountCreator.CurrentAccountCreator;
import main.java.AccountCreator.SalaryAccountCreator;
import main.java.AccountCreator.SavingsAccountCreator;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Date;

public class Bank {
    private static Bank bankInstance;
    private ArrayList<Account> accounts;

    private Bank()
    {
        accounts = new ArrayList<>();
    }

    public static Bank getBankInstance()
    {
        if(bankInstance == null)
        {
            bankInstance = new Bank();
        }
        return bankInstance;
    }

    public void addAccount(AccountCreator creator, String accountName, double openingBalance)
    {
        try {
            int accountNo = getNextAccountNo();
            Account account = creator.createAccount(Integer.toString(accountNo), accountName, openingBalance, new Date());
            accounts.add(account);
            System.out.println("Account created successfully");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public void deleteAccount(Account account)
    {
        account.delete();
    }

    public Account searchAccount(String targetAccountNo)
    {
        for (Account account : accounts) {
            if (account.getAccountNo() == targetAccountNo) {
                return account; // Found the account
            }
        }
        return null;
    }

    public void displayAllAccounts()
    {
        for (Account account : accounts) {
            account.displayAccount();
        }
    }

    public int getNextAccountNo()
    {
        return accounts.size() + 1;
    }
}
