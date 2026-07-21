package org.example.modals;

import org.example.modals.ParkingSpot.ParkingSpot;
import org.example.modals.vehicle.Vehicle;
import org.example.strategy.parkingspot.ISpotAllocationStrategy;

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

    public synchronized Ticket park(Vehicle vehicle) {
        ParkingSpot parkingSpot = spotAllocationStrategy.findSpot(
                    vehicle.getVehicleType(), floors);
        if(parkingSpot==null) throw new RuntimeException("No parking spot found");
        parkingSpot.allocate(vehicle);
        return new Ticket(parkingSpot);
    }

    public synchronized void release(Ticket ticket){
        ticket.getParkingSpot().release();
    }
}
