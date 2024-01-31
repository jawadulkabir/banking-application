package main.java;

import java.util.Vector;

public class Bank {
    private static Bank bankInstance;

    private Bank()
    {

    }

    public static Bank getBankInstance()
    {
        if(bankInstance == null)
        {
            bankInstance = new Bank();
        }
        return bankInstance;
    }
}
