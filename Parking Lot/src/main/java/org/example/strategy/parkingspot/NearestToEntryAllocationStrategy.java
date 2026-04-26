package org.example.strategy.parkingspot;

import org.example.enums.VehicleType;
import org.example.modals.EntryGate;
import org.example.modals.Floor;
import org.example.modals.ParkingSpot.LargeParkingSpot;
import org.example.modals.ParkingSpot.MediumParkingSpot;
import org.example.modals.ParkingSpot.ParkingSpot;
import org.example.modals.ParkingSpot.SmallParkingSpot;

import java.util.List;

public class NearestToEntryAllocationStrategy implements ISpotAllocationStrategy {
    @Override
    //instead we have to get the coordinates of the entry gate.
    //rat in maze problem.
    //every spot should have i,j coordinates.
    //in parking lot along with parking spots we have to maintain road as way, so we can implement rat in maze.
    //we have to find free cells.
    public ParkingSpot findSpot(VehicleType vehicleType, List<Floor> floors) {
        if(vehicleType== VehicleType.TWO_WHEELER)
            return new SmallParkingSpot();
        if(vehicleType == VehicleType.FOUR_WHEELER)
            return new MediumParkingSpot();
        if(vehicleType == VehicleType.SIX_WHEELER)
            return new LargeParkingSpot();
        return null;
    }
}
