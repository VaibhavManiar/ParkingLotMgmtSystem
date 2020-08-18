package com.udaan.plms.db;

import com.udaan.plms.model.ParkingSlot;

import java.util.List;

public interface ParkingSlotDB {
    ParkingSlot getParkingSlot(String id);
    void addParkingSlot(ParkingSlot parkingSlot);
    List<ParkingSlot> getAllParkingSlots(String parkingLotId, ParkingSlot.Type type);
}
