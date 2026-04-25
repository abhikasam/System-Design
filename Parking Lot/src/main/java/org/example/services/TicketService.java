package src.main.java.org.example.services;

import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.Ticket;
import src.main.java.org.example.modals.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class TicketService implements ITicketService{
    private final Map<String, Ticket> ticketMap;
    public TicketService(){
        ticketMap = new HashMap<>();
    }
    @Override
    public Ticket generateTicket(ParkingSpot parkingSpot) {
        Ticket ticket = new Ticket(parkingSpot);
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public Ticket getTicket(String id) {
        return ticketMap.get(id);
    }

    @Override
    public void remove(String id) {
        ticketMap.remove(id);
    }
}
