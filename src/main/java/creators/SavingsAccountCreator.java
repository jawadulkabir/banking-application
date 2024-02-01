package main.java.creators;

import main.java.accounts.Account;
import main.java.accounts.SavingsAccount;

import java.util.Date;

public class SavingsAccountCreator implements AccountCreator{
    private double  minOpeningBalance;

    public SavingsAccountCreator(double minOpeningBalance) {
        this.minOpeningBalance = minOpeningBalance;
    }

    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate)
    {
        if(openingBalance < this.minOpeningBalance)
        {
            System.out.println("Minimum " + this.minOpeningBalance + " required to open account.");
            return null;
        }
        return new SavingsAccount(accountNo, accountName, openingBalance, creationDate);
    }
}