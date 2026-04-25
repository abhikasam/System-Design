package src.main.java.org.example.strategy.parkingspot;

import src.main.java.org.example.enums.VehicleType;
import src.main.java.org.example.modals.Floor;
import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;

import java.util.List;

public interface ISpotAllocationStrategy {
    ParkingSpot findSpot(VehicleType vehicleType, List<Floor> floors);
}
