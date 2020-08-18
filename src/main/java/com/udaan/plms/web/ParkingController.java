package com.udaan.plms.web;

import com.udaan.plms.api.ParkingRequest;
import com.udaan.plms.api.Response;
import com.udaan.plms.api.Success;
import com.udaan.plms.model.ParkingSlot;
import com.udaan.plms.service.IParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController extends BaseController {

    @Autowired
    private IParkingService parkingService;

    @PostMapping("/plms/park")
    public Response<String> park(@RequestBody ParkingRequest request) {
        ParkingSlot parkingSlot = this.parkingService.park(request.getVehicle(), request.getParkingLotId());
        return new Success<>("Allotted parking slot : " + parkingSlot.getNumber());
    }

    @PostMapping("/plms/unpark")
    public Response<String> unpark(@RequestBody ParkingRequest request) {
        double amount = this.parkingService.unPark(request.getVehicle(), request.getParkingLotId());
        return new Success<>("Vehicle unparked and Parking fees : " + amount);
    }
}
