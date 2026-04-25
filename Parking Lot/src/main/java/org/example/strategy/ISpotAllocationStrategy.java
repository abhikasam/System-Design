package src.main.java.org.example.strategy;

import src.main.java.org.example.modals.ParkingSpot;
import src.main.java.org.example.modals.Vehicle;

import java.util.List;

public interface ISpotAllocationStrategy {
    ParkingSpot allocate(Vehicle vehicle, List<ParkingSpot> parkingSpotList);
}
