package com.example.threadclass.challeges;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        lock = new ReentrantLock();
    }

//    public void deposit(double amount) {
//        synchronized (this) {
//            balance += amount;
//        }
//    }
//
//    public void withdraw(double amount) {
//        synchronized (this) {
//            balance -= amount;
//        }
//    }

//    public void deposit(double amount) {
//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void withdraw(double amount) {
//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
//    }

    public void deposit(double amount) {
        try {
            if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
               try {
                   balance += amount;
               }finally {
                   lock.unlock();
               }
            } else {
                System.out.println("Could not get the Lock");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void withdraw(double amount) {
        try {
            if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the Lock");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account Number is: " + this.accountNumber);
    }
}