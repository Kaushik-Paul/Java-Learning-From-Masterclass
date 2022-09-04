package com.example.threadclass;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Form Main Thread!!");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();
    }
}
