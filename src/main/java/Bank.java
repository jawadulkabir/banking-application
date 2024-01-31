package main.java;

import main.java.Account.Account;

import java.util.ArrayList;

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

    public void addAccount(Account account)
    {
        accounts.add(account);
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
}
