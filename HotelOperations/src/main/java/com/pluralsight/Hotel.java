package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Constructor 1
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Constructor 2 (overloaded)
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (getAvailableSuites() >= numberOfRooms) {
                bookedSuites += numberOfRooms;
                return true;
            }
        } else {
            if (getAvailableBasicRooms() >= numberOfRooms) {
                bookedBasicRooms += numberOfRooms;
                return true;
            }
        }
        return false;
    }

    // === Getters ===
    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    // === Derived Getters ===
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableBasicRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    public boolean isSuiteAvailable() {
        return getAvailableSuites() > 0;
    }

    public boolean isBasicRoomAvailable() {
        return getAvailableBasicRooms() > 0;
    }
}
