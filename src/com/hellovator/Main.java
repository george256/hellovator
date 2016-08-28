package com.hellovator;

import com.objects.Elevator;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.startThread();

        String[] colors = {"green", "red", "blue", "yellow", "NO"};
        Random r = new Random();
        for(int i = 0; i < 10; ++i) {
            String c = colors[r.nextInt(5)];
            System.out.println(c);
            elevator.msgYouAre(c);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
