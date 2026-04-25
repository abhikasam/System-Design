package src.main.java.org.example.modals;

import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.vehicle.Vehicle;
import src.main.java.org.example.strategy.parkingspot.ISpotAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    ISpotAllocationStrategy spotAllocationStrategy;
    List<Floor> floors;
    public ParkingLot(ISpotAllocationStrategy spotAllocationStrategy){
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.floors = new ArrayList<>();
    }

    public ParkingLot(ISpotAllocationStrategy spotAllocationStrategy,List<Floor> floors){
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.floors = floors;
    }

    void addFloor(Floor floor){
        this.floors.add(floor);
    }

    void removeFloor(Floor floor){
        this.floors.remove(floor);
    }

    public ParkingSpot park(Vehicle vehicle,EntryGate entryGate) {
        ParkingSpot parkingSpot = spotAllocationStrategy.findSpot(
                    vehicle.getVehicleType(), floors, entryGate);
        if(parkingSpot==null) throw new RuntimeException("No parking spot found");
        parkingSpot.allocate(vehicle);
        return parkingSpot;
    }

    public void release(ParkingSpot parkingSpot){
        parkingSpot.release();
    }
}
