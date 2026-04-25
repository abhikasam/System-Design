package src.main.java.org.example.modals;

import src.main.java.org.example.enums.VehicleType;

public class EntryGate {
    String id;
    ParkingLot parkingLot;
    EntryGate(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    Ticket park(Vehicle vehicle){
        return parkingLot.park(vehicle);
    }
}
