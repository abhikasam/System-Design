package src.main.java.org.example.modals;

import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.vehicle.Vehicle;
import src.main.java.org.example.strategy.payment.IPaymentStrategy;
import src.main.java.org.example.strategy.parkingspot.ISpotAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    ISpotAllocationStrategy spotAllocationStrategy;
    IPaymentStrategy paymentStrategy;
    List<ParkingSpot> parkingSpots;
    ParkingLot(ISpotAllocationStrategy spotAllocationStrategy,IPaymentStrategy paymentStrategy){
        this.parkingSpots = new ArrayList<>();
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.paymentStrategy = paymentStrategy;
    }
    void addSpot(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    void removeSpot(ParkingSpot parkingSpot){
        this.parkingSpots.remove(parkingSpot);
    }

    Ticket issueTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpot.allocate(vehicle);
        return Ticket.issue(vehicle, parkingSpot);
    }

    public Ticket park(Vehicle vehicle) {
        ParkingSpot parkingSpot = spotAllocationStrategy.allocate(vehicle, parkingSpots);
        if(parkingSpot==null) throw new RuntimeException("No parking spot found");
        return issueTicket(vehicle, parkingSpot);
    }

    public Bill release(Ticket ticket){
        ticket.parkingSpot().release();
        return paymentStrategy.process(ticket);
    }
}
