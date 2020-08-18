package com.udaan.plms.service;

import com.udaan.plms.db.AuditParkingDB;
import com.udaan.plms.db.ParkingLotDB;
import com.udaan.plms.db.ParkingSlotDB;
import com.udaan.plms.db.RateCardDB;
import com.udaan.plms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingService implements IParkingService {

    @Autowired
    ParkingLotDB parkingLotDB;

    @Autowired
    ParkingSlotDB parkingSlotDB;

    @Autowired
    AuditParkingDB auditParkingDB;

    @Autowired
    RateCardDB rateCardDB;


    @Override
    public ParkingSlot park(Vehicle vehicle, String parkingLotId) {
        List<ParkingSlot> unAvailableParkingSlots = this.auditParkingDB.unAvailableParkingSlots(parkingLotId, ParkingSlot.getParkingSlotType(vehicle.getType()));
        List<ParkingSlot> availableParkingSlots = parkingSlotDB.getAllParkingSlots(parkingLotId, ParkingSlot.getParkingSlotType(vehicle.getType())).
                stream().
                filter(parkingSlot -> !unAvailableParkingSlots.contains(parkingSlot)).collect(Collectors.toList());
        if(availableParkingSlots.size() > 0) {
            ParkingSlot parkingSlot = availableParkingSlots.get(0);
            auditParkingDB.audit(new ParkingAudit("PA"+auditParkingDB.getNextIndex(), parkingSlot, vehicle));
            return parkingSlot;
        }
        throw new RuntimeException("No parking slot available");
    }

    @Override
    public double unPark(Vehicle vehicle, String parkingLotId) {
        ParkingAudit audit = this.auditParkingDB.getAuditForVehicle(vehicle.getNumber(), parkingLotId).stream().
                filter(parkingAudit -> parkingAudit.getStatus().equals(ParkingAudit.Status.UNPAID)).findFirst().orElse(null);
        if(audit != null) {
            audit.setStatus(ParkingAudit.Status.PAID);
            RateCard rateCard = this.rateCardDB.getRateCard(parkingLotId, audit.getDuration(), ParkingSlot.getParkingSlotType(vehicle.getType()));
            audit.setFee(rateCard.getFee());
            this.auditParkingDB.updateAudit(audit);
            return rateCard.getFee();
        }
        throw new RuntimeException("Vehicle is not parked before.");
    }
}
