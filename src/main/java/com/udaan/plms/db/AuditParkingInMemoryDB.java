package com.udaan.plms.db;

import com.udaan.plms.model.ParkingAudit;
import com.udaan.plms.model.ParkingSlot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class AuditParkingInMemoryDB implements AuditParkingDB {

    private AtomicInteger index;
    private Map<String, ParkingAudit> store = new ConcurrentHashMap<>();

    public AuditParkingInMemoryDB() {
        this.index = new AtomicInteger(1);
    }

    @Override
    public List<ParkingSlot> unAvailableParkingSlots(String parkingLotNumber) {
        return this.store.values().stream().
                filter(parkingAudit -> parkingAudit.getParkingSlot().getParkingLot().getId().equals(parkingLotNumber)).
                map(ParkingAudit::getParkingSlot).
                collect(Collectors.toList());
    }

    @Override
    public List<ParkingSlot> unAvailableParkingSlots(String parkingLotNumber, ParkingSlot.Type parkingSlotType) {
        return this.store.values().stream().
                filter(parkingAudit -> parkingAudit.getParkingSlot().getParkingLot().getId().equals(parkingLotNumber)).
                filter(parkingAudit -> parkingAudit.getParkingSlot().getType().equals(parkingSlotType)).
                filter(parkingAudit -> parkingAudit.getStatus().equals(ParkingAudit.Status.UNPAID)).
                map(ParkingAudit::getParkingSlot).
                collect(Collectors.toList());
    }

    @Override
    public List<ParkingAudit> getAuditForVehicle(String vehicleNumber, String parkingLotNumber) {
        return this.store.values().stream().
                filter(parkingAudit -> parkingAudit.getVehicle().getNumber().equalsIgnoreCase(vehicleNumber)).
                filter(parkingAudit -> parkingAudit.getParkingSlot().getParkingLot().getId().equals(parkingLotNumber)).
                filter(parkingAudit -> parkingAudit.getStatus().equals(ParkingAudit.Status.UNPAID)).
                collect(Collectors.toList());
    }

    @Override
    public List<ParkingAudit> getAuditForVehicle(String vehicleNumber) {
        return this.store.values().stream().
                filter(parkingAudit -> parkingAudit.getVehicle().getNumber().equalsIgnoreCase(vehicleNumber)).
                collect(Collectors.toList());
    }

    @Override
    public void audit(ParkingAudit parkingAudit) {
        this.store.put(parkingAudit.getNumber(), parkingAudit);
    }

    @Override
    public void updateAudit(ParkingAudit parkingAudit) {
        this.store.put(parkingAudit.getNumber(), parkingAudit);
    }

    @Override
    public int getNextIndex() {
        return this.index.getAndIncrement();
    }
}
