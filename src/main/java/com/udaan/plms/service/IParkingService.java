package com.udaan.plms.service;

import com.udaan.plms.model.ParkingAudit;
import com.udaan.plms.model.ParkingLot;
import com.udaan.plms.model.ParkingSlot;
import com.udaan.plms.model.Vehicle;

public interface IParkingService {
    ParkingSlot park(Vehicle vehicle, String parkingLotId);
    double unPark(Vehicle vehicle, String parkingLotId);
}
