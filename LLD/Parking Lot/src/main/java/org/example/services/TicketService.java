package org.example.services;

import org.example.modals.ParkingSpot.ParkingSpot;
import org.example.modals.Ticket;
import org.example.modals.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class TicketService implements ITicketService{
    private final Map<String, Ticket> ticketMap;
    public TicketService(){
        ticketMap = new HashMap<>();
    }
    @Override
    public void save(Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
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
