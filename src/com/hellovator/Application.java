package com.hellovator;

import com.data.Direction;
import com.data.PickupRequest;
import com.data.DropoffRequest;
import com.graphics.Drawer;
import com.objects.Elevator;

import java.util.Scanner;

class Application {

    void run() {
        Drawer drawer = new Drawer();
        Elevator elevator = new Elevator();
        elevator.setNumberOfFloors(5);

        drawer.setElevator(elevator);

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            drawer.draw();
            System.out.println("Enter a command:");
            input = scanner.nextLine();
            followCommands(input, elevator);
            elevator.moveToNextFloor();
        } while (!input.equals("exit"));
    }

    private void followCommands(String input, Elevator elevator) {
        if (input.equals("")) {
            return;
        }

        String[] subInputs = input.split("[;]");
        for (String s : subInputs) {
            s = s.trim();
            if (s.length() == 1) {
                int toFloor = s.charAt(0) - '0';
                DropoffRequest request = new DropoffRequest(toFloor);
                elevator.sendFloorRequest(request);
            } else {
                int fromFloor = s.charAt(0) - '0';
                Direction direction = Direction.convertCharToDirection(s.charAt(1));
                PickupRequest request = new PickupRequest(fromFloor, direction);
                elevator.sendDirectionRequest(request);
            }
        }
    }
}
