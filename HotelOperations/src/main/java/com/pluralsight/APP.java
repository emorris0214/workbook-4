package com.pluralsight;

public class APP {
    public static void main(String[] args) {
        // === Test Room ===
        Room room1 = new Room(2, 3, 150.00);
        System.out.println("Room available? " + room1.isAvailable()); // true
        if (room1.isAvailable()) {
            room1.checkIn();
            System.out.println("Checked into room.");
        } else {
            System.out.println("Room not available.");
        }
        room1.checkOut();
        System.out.println("Room available after checkout (before cleaning)? " + room1.isAvailable()); // false
        room1.cleanRoom();
        System.out.println("Room available after cleaning? " + room1.isAvailable()); // true

        System.out.println("\n---------------------------");

        // === Test Reservation ===
        Reservation res1 = new Reservation("King", 3, true);
        System.out.println("Room type: " + res1.getRoomType());
        System.out.println("Price per night: $" + res1.getPrice());
        System.out.println("Total for stay: $" + res1.getReservationTotal());

        System.out.println("\n---------------------------");

        // === Test Employee with punchIn/punchOut ===
        Employee emp = new Employee("E003", "Leonardo Cavera", "Front Desk", 20.0, 0.0);

        emp.punchIn(9.0);    // Punch in at 9:00 AM
        emp.punchOut(13.5);  // Punch out at 1:30 PM (4.5 hrs)

        emp.punchIn(14.0);   // Punch in at 2:00 PM
        emp.punchOut(18.0);  // Punch out at 6:00 PM (4 hrs)

        System.out.println(emp.getName());
        System.out.println("Total hours worked: " + emp.getHoursWorked()); // Should be 8.5
        System.out.println("Total pay: $" + emp.getTotalPay());

        System.out.println("\n---------------------------");

        // === Test Hotel (Constructor 1) ===
        Hotel hotel1 = new Hotel("Ocean View", 5, 10);
        System.out.println("Hotel Name: " + hotel1.getName());
        System.out.println("Total Suites: " + hotel1.getNumberOfSuites());
        System.out.println("Total Basic Rooms: " + hotel1.getNumberOfRooms());
        System.out.println("Available Suites: " + hotel1.getAvailableSuites());
        System.out.println("Available Basic Rooms: " + hotel1.getAvailableBasicRooms());
        System.out.println("Suite Available? " + hotel1.isSuiteAvailable());
        System.out.println("Basic Room Available? " + hotel1.isBasicRoomAvailable());

        System.out.println("\nBooking 2 suites and 3 basic rooms...");
        boolean suiteBooked = hotel1.bookRoom(2, true);
        boolean roomBooked = hotel1.bookRoom(3, false);

        System.out.println("Suite Booking Successful? " + suiteBooked);
        System.out.println("Basic Room Booking Successful? " + roomBooked);
        System.out.println("Booked Suites: " + hotel1.getBookedSuites());
        System.out.println("Booked Basic Rooms: " + hotel1.getBookedBasicRooms());
        System.out.println("Available Suites Now: " + hotel1.getAvailableSuites());
        System.out.println("Available Basic Rooms Now: " + hotel1.getAvailableBasicRooms());
        System.out.println("Suite Available? " + hotel1.isSuiteAvailable());
        System.out.println("Basic Room Available? " + hotel1.isBasicRoomAvailable());

        System.out.println("\n---------------------------");

        // === Test Hotel (Constructor 2) ===
        Hotel hotel2 = new Hotel("Mori's", 4, 6, 2, 4);
        System.out.println("Hotel Name: " + hotel2.getName());
        System.out.println("Total Suites: " + hotel2.getNumberOfSuites());
        System.out.println("Total Basic Rooms: " + hotel2.getNumberOfRooms());
        System.out.println("Booked Suites: " + hotel2.getBookedSuites());
        System.out.println("Booked Basic Rooms: " + hotel2.getBookedBasicRooms());
        System.out.println("Available Suites: " + hotel2.getAvailableSuites());
        System.out.println("Available Basic Rooms: " + hotel2.getAvailableBasicRooms());
        System.out.println("Suite Available? " + hotel2.isSuiteAvailable());
        System.out.println("Basic Room Available? " + hotel2.isBasicRoomAvailable());

        System.out.println("\nAttempting to book 3 more basic rooms...");
        boolean roomBooked2 = hotel2.bookRoom(3, false); // Should fail (only 2 available)
        System.out.println("Booking Successful? " + roomBooked2);
    }
}
