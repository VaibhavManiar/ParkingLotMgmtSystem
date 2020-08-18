package com.udaan.plms.db;

import com.udaan.plms.model.ParkingAudit;
import com.udaan.plms.model.ParkingSlot;

import java.util.List;

public interface AuditParkingDB {
    List<ParkingSlot> unAvailableParkingSlots(String parkingLotNumber);
    List<ParkingSlot> unAvailableParkingSlots(String parkingLotNumber, ParkingSlot.Type parkingSlotType);
    List<ParkingAudit> getAuditForVehicle(String vehicleNumber, String parkingLotNumber);
    List<ParkingAudit> getAuditForVehicle(String vehicleNumber);
    void audit(ParkingAudit parkingAudit);
    void updateAudit(ParkingAudit parkingAudit);
    int getNextIndex();
}
