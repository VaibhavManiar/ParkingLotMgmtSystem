package com.udaan.plms.db;

import com.udaan.plms.model.ParkingLot;

public interface ParkingLotDB {
    ParkingLot getParkingLot(String id);
    void addParkingLot(ParkingLot parkingLot);
}
