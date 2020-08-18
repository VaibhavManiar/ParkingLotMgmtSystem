package com.udaan.plms.db;

import com.udaan.plms.model.ParkingLot;
import com.udaan.plms.model.ParkingSlot;
import com.udaan.plms.model.RateCard;

import java.time.Duration;

public interface RateCardDB {
    RateCard getRateCard(String parkingLotNumber, Duration duration, ParkingSlot.Type parkingSlotType);
    void addRateCard(RateCard rateCard);
}
