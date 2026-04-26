package org.example.modals;

import org.example.modals.ParkingSpot.ParkingSpot;
import org.example.modals.vehicle.Vehicle;
import org.example.services.ITicketService;
import org.example.strategy.parkingspot.ISpotAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    ISpotAllocationStrategy spotAllocationStrategy;
    ITicketService ticketService;
    List<Floor> floors;
    public ParkingLot(ISpotAllocationStrategy spotAllocationStrategy,ITicketService ticketService){
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.floors = new ArrayList<>();
        this.ticketService = ticketService;
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

    public Ticket park(Vehicle vehicle,EntryGate entryGate) {
        ParkingSpot parkingSpot = spotAllocationStrategy.findSpot(
                    vehicle.getVehicleType(), floors, entryGate);
        if(parkingSpot==null) throw new RuntimeException("No parking spot found");
        parkingSpot.allocate(vehicle);
        return ticketService.generateTicket(parkingSpot);
    }

    public void release(ParkingSpot parkingSpot){
        parkingSpot.release();
    }
}
