package com.graphics;

import com.data.Direction;
import com.objects.*;

public class Drawer {
    private Elevator elevator;

    public void draw() {
        for(int i = 0; i < 100; ++i) {
            System.out.println("\b\b\b\b\b\b\b\b\b\b");
        }

        int numberOfFloors = elevator.getNumberOfFloors();
        int currentFloor = elevator.getCurrentFloor();
        String direction = directionToSymbol(elevator.getDirection());

        for (int i = numberOfFloors; i >= 1; --i) {
            System.out.print("| F " + i + " |");
            if (i == currentFloor) {
                System.out.print(" [ " + direction + " ]");
            }
            System.out.println();
        }
    }

    private String directionToSymbol(Direction direction) {
        if(direction == Direction.DOWN) {
            return "\\/";
        }

        if(direction == Direction.UP) {
            return "/\\";
        }

        return "--";
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }
}
