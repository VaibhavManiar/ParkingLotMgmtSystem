package com.udaan.plms.service;

import com.udaan.plms.model.ParkingAudit;

import java.util.List;

public interface IAuditService {
    List<ParkingAudit> getParkingHistory(String vehicleNumber);
}
