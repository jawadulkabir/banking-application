package main.java.AccountCreator;

import main.java.Account.Account;
import main.java.Account.CurrentAccount;

import java.util.Date;

public class CurrentAccountCreator implements AccountCreator {
    private final double  minOpeningBalance;

    public CurrentAccountCreator(double minOpeningBalance, double minBalanceAfterWithdrawal) {
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