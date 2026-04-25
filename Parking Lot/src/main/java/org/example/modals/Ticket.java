package src.main.java.org.example.modals;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String id;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    Ticket(){
        id = UUID.randomUUID().toString();
    }
    Ticket(Vehicle vehicle,ParkingSpot parkingSpot){
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        entryTime = LocalDateTime.now();
        exitTime = entryTime.plusMinutes(60);
    }
    String getId(){
        return this.id;
    }
}
