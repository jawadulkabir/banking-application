package main.java.AccountCreator;

import main.java.Account.Account;
import main.java.Account.CurrentAccount;

import java.util.Date;

public class CurrentAccountCreator implements AccountCreator {
    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate)
    {
        return new CurrentAccount(accountNo, accountName, openingBalance, creationDate);
    }
}
