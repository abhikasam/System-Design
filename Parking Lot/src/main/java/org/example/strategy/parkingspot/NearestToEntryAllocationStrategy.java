package src.main.java.org.example.strategy.parkingspot;

import src.main.java.org.example.enums.VehicleType;
import src.main.java.org.example.modals.ParkingSpot.LargeParkingSpot;
import src.main.java.org.example.modals.ParkingSpot.MediumParkingSpot;
import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.ParkingSpot.SmallParkingSpot;
import src.main.java.org.example.modals.vehicle.Vehicle;

import java.util.List;

public class NearestToEntryAllocationStrategy implements ISpotAllocationStrategy {
    @Override
    //instead we have to get the coordinates of the entry gate.
    //rat in maze problem.
    //every spot should have i,j coordinates.
    //in parking lot along with parking spots we have to maintain road as way, so we can implement rat in maze.
    //we have to find free cells.
    public ParkingSpot findSpot(Vehicle vehicle, List<ParkingSpot> parkingSpotList) {
        if(vehicle.getVehicleType()== VehicleType.TWO_WHEELER)
            return new SmallParkingSpot();
        if(vehicle.getVehicleType() == VehicleType.FOUR_WHEELER)
            return new MediumParkingSpot();
        if(vehicle.getVehicleType() == VehicleType.SIX_WHEELER)
            return new LargeParkingSpot();
        return null;
    }
}
