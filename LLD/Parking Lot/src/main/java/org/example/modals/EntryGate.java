package org.example.modals;

import org.example.modals.ParkingSpot.ParkingSpot;
import org.example.modals.vehicle.Vehicle;
import org.example.services.ITicketService;
import org.example.modals.ParkingLot;

public class EntryGate {
    ParkingLot parkingLot;
    ITicketService ticketService;
    public EntryGate(ParkingLot parkingLot,ITicketService ticketService){
        this.parkingLot = parkingLot;
        this.ticketService = ticketService;
    }


    public Ticket park(Vehicle vehicle){
        Ticket ticket = parkingLot.park(vehicle);
        ticketService.save(ticket);
        return  ticket;
    }
}
