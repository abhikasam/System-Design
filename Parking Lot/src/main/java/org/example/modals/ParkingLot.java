package src.main.java.org.example.modals;

import src.main.java.org.example.strategy.ISpotAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    ISpotAllocationStrategy spotAllocationStrategy;
    List<ParkingSpot> parkingSpots;
    ParkingLot(ISpotAllocationStrategy spotAllocationStrategy){
        this.parkingSpots = new ArrayList<>();
        this.spotAllocationStrategy = spotAllocationStrategy;
    }
    void addSpot(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    void removeSpot(ParkingSpot parkingSpot){
        this.parkingSpots.remove(parkingSpot);
    }

    Ticket issueTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpot.allocate(vehicle);
        return new Ticket(vehicle,parkingSpot);
    }

    public Ticket park(Vehicle vehicle) {
        ParkingSpot parkingSpot = spotAllocationStrategy.allocate(vehicle, parkingSpots);
        if(parkingSpot==null) throw new RuntimeException("No parking spot found");
        return issueTicket(vehicle, parkingSpot);
    }
}
