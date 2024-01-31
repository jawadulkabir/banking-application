package main.java.AccountCreator;

import main.java.Account.Account;

import java.util.Date;

public interface AccountCreator {
    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate);
}
