package main.java.creators;

import main.java.AccountType;
import main.java.accounts.Account;
import main.java.accounts.CurrentAccount;

import java.util.Date;

public class CurrentAccountCreator implements AccountCreator {

    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate)
    {
        if(openingBalance < AccountType.CURRENT.getMinOpeningBalance())
        {
            System.out.println("Minimum " + AccountType.CURRENT.getMinOpeningBalance() + " required to open account.");
            return null;
        }
        return new CurrentAccount(accountNo, accountName, openingBalance, creationDate);
    }
}