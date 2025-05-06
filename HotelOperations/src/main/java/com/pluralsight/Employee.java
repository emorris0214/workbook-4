package com.pluralsight;
import java.time.LocalDateTime;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private Double startTime; // allows null value

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.startTime = null;
    }

    public void punchIn(double time) {
        startTime = time;
    }

    public void punchOut(double time) {
        if (startTime == null) {
            System.out.println("Error: Employee must punch in before punching out.");
            return;
        }

        if (time < startTime) {
            System.out.println("Error: Punch out time cannot be earlier than punch in time.");
            return;
        }

        double shiftHours = time - startTime;
        hoursWorked += shiftHours;
        startTime = null; // reset for next shift

    }

    // Overloaded Methods (In & Out)
    public void punchIn() {
        double time = getCurrentDecimalTime();
        punchIn(time);
    }

    public void punchOut() {
        double time = getCurrentDecimalTime();
        punchOut(time);
    }

    private double getCurrentDecimalTime() {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        return hour + (minute / 60.0);
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public String getName() {
        return name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
}
