package main.java;

import main.java.accounts.Account;
import main.java.creators.AccountCreator;

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
            if(account != null)
            {
                accounts.add(account);
                System.out.println("Account created successfully");
            }
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
            if (account.getAccountNo().equals(targetAccountNo)) {
                return account; // Found the account
            }
        }
        return null;
    }

    public void displayAllAccounts()
    {
        for (Account account : accounts) {
            if(!account.isDeleted())
                account.displayAccount();
        }
    }

    public int getNextAccountNo()
    {
        return accounts.size() + 1;
    }
}
