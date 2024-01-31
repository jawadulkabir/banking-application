package main.java.AccountCreator;

import main.java.Account.Account;
import main.java.Account.SavingsAccount;

import java.util.Date;

public class SavingsAccountCreator implements AccountCreator{
    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate)
    {
        return new SavingsAccount(accountNo, accountName, openingBalance, creationDate);
    }
}
