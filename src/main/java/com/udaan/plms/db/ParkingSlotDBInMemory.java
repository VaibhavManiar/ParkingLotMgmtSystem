package com.udaan.plms.db;

import com.udaan.plms.model.ParkingLot;
import com.udaan.plms.model.ParkingSlot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class ParkingSlotDBInMemory implements ParkingSlotDB {

    private final Map<String, ParkingSlot> store = new ConcurrentHashMap<>();

    public ParkingSlotDBInMemory() {
        dummyInit();
    }

    @Override
    public ParkingSlot getParkingSlot(String id) {
        return this.store.get(id);
    }

    @Override
    public void addParkingSlot(ParkingSlot parkingSlot) {
        this.store.put(parkingSlot.getNumber(), parkingSlot);
    }

    @Override
    public List<ParkingSlot> getAllParkingSlots(String parkingLotId, ParkingSlot.Type type) {
        return this.store.values().stream().
                filter(parkingSlot -> parkingSlot.getParkingLot().getId().equals(parkingLotId) && parkingSlot.getType().equals(type)).
                collect(Collectors.toList());
    }

    private void dummyInit() {
        ParkingLot parkingLot = new ParkingLot("PL1", "PL1", "HSR");
        addParkingSlot(new ParkingSlot("PS1", ParkingSlot.Type.TwoWheeler, parkingLot));
        addParkingSlot(new ParkingSlot("PS2", ParkingSlot.Type.TwoWheeler, parkingLot));
        addParkingSlot(new ParkingSlot("PS3", ParkingSlot.Type.TwoWheeler, parkingLot));

        addParkingSlot(new ParkingSlot("PS4", ParkingSlot.Type.Hatchback, parkingLot));
        addParkingSlot(new ParkingSlot("PS5", ParkingSlot.Type.Hatchback, parkingLot));
        addParkingSlot(new ParkingSlot("PS6", ParkingSlot.Type.Hatchback, parkingLot));

        addParkingSlot(new ParkingSlot("PS7", ParkingSlot.Type.Sedan, parkingLot));
        addParkingSlot(new ParkingSlot("PS8", ParkingSlot.Type.Sedan, parkingLot));
        addParkingSlot(new ParkingSlot("PS9", ParkingSlot.Type.Sedan, parkingLot));

        addParkingSlot(new ParkingSlot("PS10", ParkingSlot.Type.SUV, parkingLot));
        addParkingSlot(new ParkingSlot("PS11", ParkingSlot.Type.SUV, parkingLot));
        addParkingSlot(new ParkingSlot("PS12", ParkingSlot.Type.SUV, parkingLot));

        addParkingSlot(new ParkingSlot("PS13", ParkingSlot.Type.XUV, parkingLot));
        addParkingSlot(new ParkingSlot("PS14", ParkingSlot.Type.XUV, parkingLot));
        addParkingSlot(new ParkingSlot("PS15", ParkingSlot.Type.XUV, parkingLot));


        ParkingLot parkingLot1 = new ParkingLot("PL2", "PL2", "Electronic City");
        addParkingSlot(new ParkingSlot("PS16", ParkingSlot.Type.TwoWheeler, parkingLot1));
        addParkingSlot(new ParkingSlot("PS17", ParkingSlot.Type.TwoWheeler, parkingLot1));
        addParkingSlot(new ParkingSlot("PS18", ParkingSlot.Type.TwoWheeler, parkingLot1));

        addParkingSlot(new ParkingSlot("PS19", ParkingSlot.Type.Hatchback, parkingLot1));
        addParkingSlot(new ParkingSlot("PS20", ParkingSlot.Type.Hatchback, parkingLot1));
        addParkingSlot(new ParkingSlot("PS21", ParkingSlot.Type.Hatchback, parkingLot1));

        addParkingSlot(new ParkingSlot("PS22", ParkingSlot.Type.Sedan, parkingLot1));
        addParkingSlot(new ParkingSlot("PS23", ParkingSlot.Type.Sedan, parkingLot1));
        addParkingSlot(new ParkingSlot("PS24", ParkingSlot.Type.Sedan, parkingLot1));

        addParkingSlot(new ParkingSlot("PS25", ParkingSlot.Type.SUV, parkingLot1));
        addParkingSlot(new ParkingSlot("PS26", ParkingSlot.Type.SUV, parkingLot1));
        addParkingSlot(new ParkingSlot("PS27", ParkingSlot.Type.SUV, parkingLot1));

        addParkingSlot(new ParkingSlot("PS28", ParkingSlot.Type.XUV, parkingLot1));
        addParkingSlot(new ParkingSlot("PS29", ParkingSlot.Type.XUV, parkingLot1));
        addParkingSlot(new ParkingSlot("PS30", ParkingSlot.Type.XUV, parkingLot1));
    }
}
