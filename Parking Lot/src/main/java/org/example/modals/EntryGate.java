package src.main.java.org.example.modals;

import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.vehicle.Vehicle;
import src.main.java.org.example.services.ITicketService;

public class EntryGate {
    ParkingLot parkingLot;
    ITicketService ticketService;
    public EntryGate(ParkingLot parkingLot,ITicketService ticketService){
        this.parkingLot = parkingLot;
        this.ticketService = ticketService;
    }


    public Ticket park(Vehicle vehicle){
        ParkingSpot parkingSpot = parkingLot.park(vehicle,this);
        return ticketService.generateTicket(parkingSpot);
    }
}
