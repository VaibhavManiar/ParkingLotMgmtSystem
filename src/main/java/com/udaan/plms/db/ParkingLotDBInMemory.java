package com.udaan.plms.db;

import com.udaan.plms.model.ParkingLot;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ParkingLotDBInMemory implements ParkingLotDB {

    private final Map<String, ParkingLot> store = new ConcurrentHashMap<>();

    public ParkingLotDBInMemory() {
        this.dummyInit();
    }

    @Override
    public ParkingLot getParkingLot(String id) {
        return store.get(id);
    }

    @Override
    public void addParkingLot(ParkingLot parkingLot) {
        store.put(parkingLot.getId(), parkingLot);
    }

    private void dummyInit() {
        this.store.put("PL1", new ParkingLot("PL1", "PL1", "HSR"));
        this.store.put("PL2", new ParkingLot("PL2", "PL2", "Electronic City"));
    }
}
