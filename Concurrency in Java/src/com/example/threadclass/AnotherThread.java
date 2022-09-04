package com.example.threadclass;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello From Another Thread!!");
    }
}
