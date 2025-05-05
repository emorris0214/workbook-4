package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty){
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    // Room Check In: Must be Available
    public boolean checkIn() {
        if (isAvailable()) {
            isOccupied = true;
            isDirty = true;
            return true;
        }
        return false; // Cannot check in
    }

    public void checkOut() {
        if (isOccupied) {
            isOccupied = false;
            // isDirty stays true until cleaned
        }
    }

    public void cleanRoom() {
        isDirty = false;
    }
}
