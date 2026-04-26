package org.example.modals;

import lombok.Data;
import org.example.enums.VehicleType;
import org.example.modals.ParkingSpot.ParkingSpot;
import org.example.modals.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Ticket {
    String id;
    ParkingSpot parkingSpot;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    public Ticket(ParkingSpot parkingSpot){
        this.id = UUID.randomUUID().toString();
        this.setParkingSpot(parkingSpot);
        this.setExitTime(LocalDateTime.now());
    }
}
