package src.main.java.org.example.strategy.parkingspot;

import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.vehicle.Vehicle;

import java.util.List;

public interface ISpotAllocationStrategy {
    ParkingSpot findSpot(Vehicle vehicle, List<ParkingSpot> parkingSpotList);
}
