package com.data;

public class PickupRequest {
    private int fromFloor;
    private Direction direction;

    public PickupRequest(int fromFloor, Direction direction) {
        this.fromFloor = fromFloor;
        this.direction = direction;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public void setFromFloor(int fromFloor) {
        this.fromFloor = fromFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
