package main.java.AccountCreator;

import main.java.Account.Account;
import main.java.Account.SalaryAccount;

import java.util.Date;

public class SalaryAccountCreator implements AccountCreator {
    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate)
    {
        return new SalaryAccount(accountNo, accountName, openingBalance, creationDate);
    }
}
