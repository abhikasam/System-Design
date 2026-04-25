package src.main.java.org.example.modals;

import src.main.java.org.example.enums.VehicleType;
import src.main.java.org.example.modals.ParkingSpot.ParkingSpot;
import src.main.java.org.example.modals.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record Ticket (
    String id,
    Vehicle vehicle,
    ParkingSpot parkingSpot,
    LocalDateTime entryTime,
    LocalDateTime exitTime,
    VehicleType vehicleType,
    int fee
){
    public static Ticket issue(Vehicle vehicle,ParkingSpot parkingSpot){
        return new Ticket(
                UUID.randomUUID().toString(),
                vehicle,parkingSpot,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(60),
                parkingSpot.getVehicleType(),
                parkingSpot.getPrize());
    }
}
