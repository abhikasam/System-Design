package src.main.java.org.example.modals;

import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.vehicle.Vehicle;
import src.main.java.org.example.services.ITicketService;
import src.main.java.org.example.services.TicketService;
import src.main.java.org.example.strategy.payment.IPaymentStrategy;
import src.main.java.org.example.strategy.parkingspot.ISpotAllocationStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ParkingSpot park(Vehicle vehicle) {
        ParkingSpot parkingSpot = spotAllocationStrategy.findSpot(vehicle, parkingSpots);
        if(parkingSpot==null) throw new RuntimeException("No parking spot found");
        parkingSpot.allocate(vehicle);
        return parkingSpot;
    }

    public void release(ParkingSpot parkingSpot){
        parkingSpot.release();
    }
}
