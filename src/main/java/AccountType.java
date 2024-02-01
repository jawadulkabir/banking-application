package main.java;

public enum AccountType {
    SAVINGS(1000.0, 500),
    CURRENT(500.0, 300),
    SALARY(0.0, 0);

    private final double minOpeningBalance;
    private final double minBalanceAfterWithdrawal;

    AccountType(double minOpeningBalance, double minBalanceAfterWithdrawal) {
        this.minOpeningBalance = minOpeningBalance;
        this.minBalanceAfterWithdrawal = minBalanceAfterWithdrawal;
    }

    public double getMinOpeningBalance() {
        return minOpeningBalance;
    }

    public double getMinBalanceAfterWithdrawal() {
        return minBalanceAfterWithdrawal;
    }
}
