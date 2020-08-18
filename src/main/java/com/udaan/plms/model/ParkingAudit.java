package com.udaan.plms.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingAudit {
    private final String number;
    private final ParkingSlot parkingSlot;
    private final Vehicle vehicle;
    private Status status;
    private final LocalDateTime timestamp;
    private double fee;

    public void markPaid() {
        this.status = Status.PAID;
    }

    public Duration getDuration() {
        return Duration.between(LocalDateTime.now(), this.timestamp);
    }

    public ParkingAudit(String number, ParkingSlot parkingSlot, Vehicle vehicle) {
        this.number = number;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
        this.timestamp = LocalDateTime.now();
        this.status = Status.UNPAID;
    }

    public String getNumber() {
        return number;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public enum Status {
        PAID, UNPAID
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
