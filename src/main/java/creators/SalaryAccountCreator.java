package main.java.creators;

import main.java.AccountType;
import main.java.accounts.Account;
import main.java.accounts.SalaryAccount;

import java.util.Date;

public class SalaryAccountCreator implements AccountCreator {

    public Account createAccount(String accountNo, String accountName, double openingBalance, Date creationDate)
    {
        if(openingBalance < AccountType.SALARY.getMinOpeningBalance())
        {
            System.out.println("Minimum " + AccountType.SALARY.getMinOpeningBalance() + " required to open account.");
            return null;
        }
        return new SalaryAccount(accountNo, accountName, openingBalance, creationDate);
    }
}