package com.objects;

public class Elevator extends Agent {

    private String color = "default";

    public void msgYouAre(String msg) {
        color = msg;
        permit.release();
    }

    @Override
    public boolean decide() {
        if(color.equals("green")) {
            System.out.println("I am tree");
            color = "default";
            return true;
        }
        if(color.equals("red")) {
            System.out.println("I am rose");
            color = "default";
            return true;
        }
        if(color.equals("blue")) {
            System.out.println("I am ocean");
            color = "default";
            return true;
        }
        if(color.equals("yellow")) {
            System.out.println("I am sun");
            color = "default";
            return true;
        }

        return false;
    }
}
