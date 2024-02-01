package main.java.accounts;

import main.java.AccountType;

import java.util.Date;

public class CurrentAccount extends Account {
    public CurrentAccount(String accountNo, String accountName, double balance, Date creationDate) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public void displayAccount()
    {
        if(!isDeleted)
        {
            super.displayAccount();
            System.out.println("Account Type: Current Account");
        }
        else
        {
            System.out.println("Account does not exist");
        }
    }

    @Override
    public void depositAmount(double amt)
    {
        if(isDeleted)
            System.out.println("Account does not exist");
        else
        {
            if(amt < 0)
            {
                System.out.println("Invalid deposit");
            }
            else
            {
                this.balance += amt;
                System.out.println("Deposit successful. New Balance: " + balance);
            }
        }
    }

    @Override
    public void withdrawAmount(double amt)
    {
        if(isDeleted)
            System.out.println("Account does not exist");
        else
        {
            if(balance - amt < AccountType.CURRENT.getMinBalanceAfterWithdrawal())
            {
                System.out.println("You cannot withdraw this amount");
            }
            else
            {
                this.balance -= amt;
                System.out.println("Withdrawal successful. New Balance: " + balance);
            }
        }
    }
}
