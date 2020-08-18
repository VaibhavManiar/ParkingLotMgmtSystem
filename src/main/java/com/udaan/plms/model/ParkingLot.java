package com.udaan.plms.model;

public class ParkingLot {
    private final String id;
    private final String name;
    private final String address;
    private double sizeInSqrt;

    public ParkingLot(String id, String name, String address, double sizeInSqrt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sizeInSqrt = sizeInSqrt;
    }

    public ParkingLot(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sizeInSqrt = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSizeInSqrt() {
        return sizeInSqrt;
    }

    public void setSizeInSqrt(double sizeInSqrt) {
        this.sizeInSqrt = sizeInSqrt;
    }
}
