package com.pluralsight;

public class APP {
    public static void main(String[] args) {
        // === Test Room ===
        Room room1 = new Room(2, 150.00, false, false);
        System.out.println("Room available? " + room1.isAvailable()); // true
        if (room1.checkIn()) {
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
    }
}
