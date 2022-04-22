package com.citb408.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accountList;
    private double limitATM;
    private double limitCashDesk;

    public Bank() {
        accountList = new ArrayList();
    }

    public Bank(String name) {
        this.name = name;
        this.accountList = new ArrayList();
    }
    public Bank(String name, double limitATM, double limitCashDesk) {
        this.name = name;
        this.limitATM = limitATM;
        this.limitCashDesk = limitCashDesk;
        this.accountList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void addAccount(Account account) {
        if(!this.accountList.contains(account)){
            this.accountList.add(account);
        }
    }

    public void deposit(Account account, double funds) throws IllegalArgumentException{
        if (funds <= 0) {
            throw new IllegalArgumentException("Funds must be positive number, but " + funds + " is passed.");
        } else {
            account.setFunds(account.getFunds() + funds);
        }
    }

    public void withdraw(Account account, double funds) throws IllegalArgumentException {
        if (funds < 0) {
            throw new IllegalArgumentException("Funds must be positive number but " + funds + " is passed.");
        } else {
            account.setFunds(account.getFunds() - funds);
        }
    }

    public void withdrawWithLimit(Account account, double funds, double limit) throws IllegalArgumentException, NotEnoughFundsException, LimitExceededException {
        if (funds > limit) {
            throw new LimitExceededException(limit, funds);
        } else if (account.getFunds() < funds) {
            throw new NotEnoughFundsException(account.getFunds(), funds);
        } else {
            withdraw(account, funds);
        }
    }
    public void withdrawATM(Account account, double funds) throws LimitExceededException, NotEnoughFundsException {
        withdrawWithLimit(account, funds, limitATM);
    }

    public void withdrawCashDesk(Account account, double funds) throws LimitExceededException, NotEnoughFundsException {
        withdrawWithLimit(account, funds, limitCashDesk);
    }

    public void displayAccounts() {
        for (Account account : this.accountList) {
            System.out.println(account);
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accountList=" + accountList +
                ", limitATM=" + limitATM +
                ", limitCashDesk=" + limitCashDesk +
                '}';
    }
}
