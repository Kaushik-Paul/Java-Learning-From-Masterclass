package com.example.threadclass;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Form Main Thread!!");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        System.out.println("Hello from Main method again");

        Thread newRunnableThread = new Thread(new RunnableThread());
        newRunnableThread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello From a Anonymous Runnable Thread !!!");
                try {
                    anotherThread.join();
                } catch (InterruptedException e) {
                    System.out.println("Another Thread Interrupted !!!");
                }
                System.out.println(ThreadColor.ANSI_PURPLE + "Another Thread has completed execution. So, I'm running again !!!");

            }
        }).start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("Hello From Anonymous Main Thread !!! ");
            }
        }.start();
    }
}
