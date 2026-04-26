package org.example.services;

import org.example.modals.ParkingSpot.ParkingSpot;
import org.example.modals.Ticket;
import org.example.modals.vehicle.Vehicle;

import java.util.Map;

public interface ITicketService {
    Ticket generateTicket(ParkingSpot parkingSpot);

    Ticket getTicket(String id);

    void remove(String id);
}
