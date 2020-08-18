package com.udaan.plms.db;

import com.udaan.plms.model.ParkingSlot;
import com.udaan.plms.model.RateCard;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateCardInMemoryDB implements RateCardDB {

    private final Map<String, RateCard> store = new ConcurrentHashMap<>();

    public RateCardInMemoryDB() {
        dummyInit();
    }

    @Override
    public RateCard getRateCard(String parkingLotNumber, Duration duration, ParkingSlot.Type parkingSlotType) {
        return this.store.values().stream().
                filter(rateCard -> rateCard.getParkingLotNumber().equals(parkingLotNumber)
                        && rateCard.getFromDuration().compareTo(duration) <= 0
                        && rateCard.getToDuration().compareTo(duration) >= 0
                        && rateCard.getParkingSlotType().equals(parkingSlotType)).findFirst().orElse(null);
    }

    @Override
    public void addRateCard(RateCard rateCard) {
        this.store.put(rateCard.getId(), rateCard);
    }

    private void dummyInit() {
        addRateCard(new RateCard("RC1", ParkingSlot.Type.TwoWheeler, 10, Duration.ofHours(1), Duration.ofHours(2), "PL1"));
        addRateCard(new RateCard("RC2", ParkingSlot.Type.Sedan, 20, Duration.ofHours(1), Duration.ofHours(2), "PL1"));
        addRateCard(new RateCard("RC3", ParkingSlot.Type.Hatchback, 15, Duration.ofHours(1), Duration.ofHours(2), "PL1"));
        addRateCard(new RateCard("RC4", ParkingSlot.Type.SUV, 25, Duration.ofHours(1), Duration.ofHours(2), "PL1"));
        addRateCard(new RateCard("RC5", ParkingSlot.Type.XUV, 30, Duration.ofHours(1), Duration.ofHours(2), "PL1"));

        addRateCard(new RateCard("RC5", ParkingSlot.Type.TwoWheeler, 10 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL1"));
        addRateCard(new RateCard("RC7", ParkingSlot.Type.Sedan, 20 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL1"));
        addRateCard(new RateCard("RC8", ParkingSlot.Type.Hatchback, 15 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL1"));
        addRateCard(new RateCard("RC9", ParkingSlot.Type.SUV, 25 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL1"));
        addRateCard(new RateCard("RC10", ParkingSlot.Type.XUV, 30 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL1"));


        addRateCard(new RateCard("RC11", ParkingSlot.Type.TwoWheeler, 10, Duration.ofHours(1), Duration.ofHours(2), "PL2"));
        addRateCard(new RateCard("RC12", ParkingSlot.Type.Sedan, 20, Duration.ofHours(1), Duration.ofHours(2), "PL2"));
        addRateCard(new RateCard("RC13", ParkingSlot.Type.Hatchback, 15, Duration.ofHours(1), Duration.ofHours(2), "PL2"));
        addRateCard(new RateCard("RC14", ParkingSlot.Type.SUV, 25, Duration.ofHours(1), Duration.ofHours(2), "PL2"));
        addRateCard(new RateCard("RC15", ParkingSlot.Type.XUV, 30, Duration.ofHours(1), Duration.ofHours(2), "PL2"));

        addRateCard(new RateCard("RC16", ParkingSlot.Type.TwoWheeler, 10 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL2"));
        addRateCard(new RateCard("RC17", ParkingSlot.Type.Sedan, 20 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL2"));
        addRateCard(new RateCard("RC18", ParkingSlot.Type.Hatchback, 15 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL2"));
        addRateCard(new RateCard("RC19", ParkingSlot.Type.SUV, 25 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL2"));
        addRateCard(new RateCard("RC20", ParkingSlot.Type.XUV, 30 * 2, Duration.ofHours(2), Duration.ofHours(5), "PL2"));
    }
}
