package com.udaan.plms.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.udaan.plms.model.Vehicle;

public class ParkingRequest {
    private final Vehicle vehicle;
    private final String parkingLotId;

    @JsonCreator
    public ParkingRequest(@JsonProperty Vehicle vehicle, @JsonProperty("parkingLot") String parkingLotId) {
        this.vehicle = vehicle;
        this.parkingLotId = parkingLotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }
}
