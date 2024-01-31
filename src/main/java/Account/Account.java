package main.java.Account;

import java.util.Date;

public abstract class Account {
    protected String accountNo;
    protected String accountName;
    protected double balance;
    protected Date creationDate;
    protected boolean isDeleted;

    public Account() {
        this.isDeleted = false;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void displayAccount()
    {
        System.out.println("Account Details:");
        System.out.println("Account Number: " + accountNo);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: $" + balance);
        System.out.println("Creation Date: " + creationDate);
    }

    public void updateAccount(String newName)
    {
        if(isDeleted)
            System.out.println("Account does not exist");
        else
        {
            this.accountName = newName;
            System.out.println("Updated");
        }
    }

    public void delete()
    {
        if(isDeleted)
            System.out.println("Account does not exist");
        else
        {
            this.isDeleted = true;
            System.out.println("Deleted");
        }
    }

    abstract public void depositAmount(double amt);
    abstract public void withdrawAmount(double amt);
}
