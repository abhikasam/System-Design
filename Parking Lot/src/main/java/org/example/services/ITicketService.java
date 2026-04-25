package src.main.java.org.example.services;

import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.Ticket;
import src.main.java.org.example.modals.vehicle.Vehicle;

import java.util.Map;

public interface ITicketService {
    Ticket generateTicket(ParkingSpot parkingSpot);

    Ticket getTicket(String id);

    void remove(String id);
}
