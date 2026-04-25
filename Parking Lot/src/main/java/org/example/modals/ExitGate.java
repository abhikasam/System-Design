package src.main.java.org.example.modals;

import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.vehicle.Vehicle;

public class ExitGate {
    ParkingLot parkingLot;
    Bill release(Ticket ticket){
        return parkingLot.release(ticket);
    }
}
