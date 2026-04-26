package org.example.modals;

import org.example.modals.ParkingSpot.ParkingSpot;
import org.example.modals.vehicle.Vehicle;
import org.example.services.ITicketService;
import org.example.modals.ParkingLot;

public class EntryGate {
    ParkingLot parkingLot;
    public EntryGate(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }


    public Ticket park(Vehicle vehicle){
       return parkingLot.park(vehicle,this);
    }
}
