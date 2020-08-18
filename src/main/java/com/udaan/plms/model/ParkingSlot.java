package com.udaan.plms.model;

public class ParkingSlot {
    private final String number;
    private final Type type;
    private final ParkingLot parkingLot;

    public ParkingSlot(String number, Type type, ParkingLot parkingLot) {
        this.number = number;
        this.type = type;
        this.parkingLot = parkingLot;
    }

    public String getNumber() {
        return number;
    }

    public Type getType() {
        return type;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public enum Type {
        TwoWheeler, Hatchback, Sedan, SUV, XUV
    }

    public static ParkingSlot.Type getParkingSlotType(Vehicle.Type vehicleType) {
        switch (vehicleType) {
            case TwoWheeler:
                return ParkingSlot.Type.TwoWheeler;
            case Hatchback:
                return ParkingSlot.Type.Hatchback;
            case Sedan:
                return ParkingSlot.Type.Sedan;
            case SUV:
                return ParkingSlot.Type.SUV;
            case XUV:
                return ParkingSlot.Type.XUV;
        }
        return null;
    }
}
