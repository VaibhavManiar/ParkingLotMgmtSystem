package com.udaan.plms.service;

import com.udaan.plms.db.AuditParkingDB;
import com.udaan.plms.model.ParkingAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService implements IAuditService {

    @Autowired
    AuditParkingDB auditParkingDB;

    @Override
    public List<ParkingAudit> getParkingHistory(String vehicleNumber) {
        return auditParkingDB.getAuditForVehicle(vehicleNumber);
    }
}
