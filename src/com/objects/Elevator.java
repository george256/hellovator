package com.objects;

import com.data.Direction;
import com.data.PickupRequest;
import com.data.DropoffRequest;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    private int currentFloor;
    private int numberOfFloors;
    private Direction direction;
    private Queue<PickupRequest> pickupRequests;
    private Queue<DropoffRequest> dropoffRequests;

    public Elevator() {
        numberOfFloors = 2;
        currentFloor = 1;

        pickupRequests = new LinkedList<>();
        dropoffRequests = new LinkedList<>();
    }

    public void moveToNextFloor() {
        if (!dropoffRequests.isEmpty()) {
            int toFloor = dropoffRequests.remove().getToFloor();

            if (toFloor > currentFloor) {
                direction = Direction.UP;
            } else if (toFloor < currentFloor) {
                direction = Direction.DOWN;
            } else {
                direction = Direction.NONE;
            }

            currentFloor = toFloor;
        } else if (!pickupRequests.isEmpty()) {
            int fromFloor = pickupRequests.remove().getFromFloor();

            if (fromFloor > currentFloor) {
                direction = Direction.UP;
            } else if (fromFloor < currentFloor) {
                direction = Direction.DOWN;
            } else {
                direction = Direction.NONE;
            }

            currentFloor = fromFloor;
        } else {
            direction = Direction.NONE;
        }
    }

    public boolean sendFloorRequest(DropoffRequest request) {
        if (!isFloorRequestValid(request)) {
            return false;
        }

        dropoffRequests.add(request);

        return true;
    }

    public boolean sendDirectionRequest(PickupRequest request) {
        if (!isDirectionRequestValid(request)) {
            return false;
        }

        pickupRequests.add(request);

        return true;
    }

    private boolean isDirectionRequestValid(PickupRequest request) {
        if (request.getFromFloor() < 1 || request.getFromFloor() > numberOfFloors) {
            return false;
        }

        if (request.getFromFloor() == 1 && request.getDirection() == Direction.DOWN) {
            return false;
        }

        if (request.getFromFloor() == numberOfFloors && request.getDirection() == Direction.UP) {
            return false;
        }

        return true;
    }

    private boolean isFloorRequestValid(DropoffRequest request) {
        if (request.getToFloor() < 1 || request.getToFloor() > numberOfFloors) {
            return false;
        }

        return true;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
