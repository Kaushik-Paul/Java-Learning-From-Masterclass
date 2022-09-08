package com.example.threadclass;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello From Another Thread!!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread Sleeping is interrupted. So, I am awake again !!!");
            return;
        }
        System.out.println(ThreadColor.ANSI_RED + "Three Second has passed so I am Awake !!!");

    }
}
