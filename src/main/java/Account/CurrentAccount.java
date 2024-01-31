package main.java.Account;

import java.util.Date;

public class CurrentAccount extends Account {
    public CurrentAccount(String accountNo, String accountName, double balance, Date creationDate) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    @Override
    public void depositAmount()
    {

    }
    @Override
    public void updateAccount()
    {

    }
    @Override
    public void withdrawAmount()
    {

    }
}
