package com.udaan.plms.model;

import java.time.Duration;

public class RateCard {
    private final String id;
    private final ParkingSlot.Type parkingSlotType;
    private double fee;
    private Duration fromDuration;
    private Duration toDuration;
    private final String parkingLotNumber;

    public RateCard(String id, ParkingSlot.Type parkingSlotType, double fee, Duration fromDuration, Duration toDuration, String parkingLotNumber) {
        this.id = id;
        this.parkingSlotType = parkingSlotType;
        this.fee = fee;
        this.fromDuration = fromDuration;
        this.toDuration = toDuration;
        this.parkingLotNumber = parkingLotNumber;
    }

    public String getId() {
        return id;
    }

    public ParkingSlot.Type getParkingSlotType() {
        return parkingSlotType;
    }

    public double getFee() {
        return fee;
    }

    public Duration getFromDuration() {
        return fromDuration;
    }

    public void setFromDuration(Duration fromDuration) {
        this.fromDuration = fromDuration;
    }

    public Duration getToDuration() {
        return toDuration;
    }

    public void setToDuration(Duration toDuration) {
        this.toDuration = toDuration;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }


    public String getParkingLotNumber() {
        return parkingLotNumber;
    }
}
