package com.example.threadclass.challeges;

public class Main {

    public static void main(String[] args) {
        BankAccount2 account = new BankAccount2("account", 1000);

        Thread person1 = new Thread() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
            }
        };

        Thread person2 = new Thread() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        };

        person1.start();
        person2.start();

    }
}
