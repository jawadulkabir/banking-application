package main.java.creators;

import main.java.AccountType;
import main.java.accounts.Account;
import main.java.accounts.SavingsAccount;

import java.util.Date;

public class SavingsAccountCreator implements AccountCreator{
    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate)
    {
        if(openingBalance < AccountType.SAVINGS.getMinOpeningBalance())
        {
            System.out.println("Minimum " + AccountType.SAVINGS.getMinOpeningBalance() + " required to open account.");
            return null;
        }
        return new SavingsAccount(accountNo, accountName, openingBalance, creationDate);
    }
}