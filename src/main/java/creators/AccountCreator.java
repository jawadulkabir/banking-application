package main.java.creators;

import main.java.accounts.Account;

import java.util.Date;

public interface AccountCreator {
    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate);
}
