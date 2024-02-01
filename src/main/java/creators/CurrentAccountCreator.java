package main.java.creators;

import main.java.accounts.Account;
import main.java.accounts.CurrentAccount;

import java.util.Date;

public class CurrentAccountCreator implements AccountCreator {
    private final double  minOpeningBalance;

    public CurrentAccountCreator(double minOpeningBalance) {
        this.minOpeningBalance = minOpeningBalance;
    }

    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate)
    {
        if(openingBalance < this.minOpeningBalance)
        {
            System.out.println("Minimum " + this.minOpeningBalance + " required to open account.");
            return null;
        }
        return new CurrentAccount(accountNo, accountName, openingBalance, creationDate);
    }
}