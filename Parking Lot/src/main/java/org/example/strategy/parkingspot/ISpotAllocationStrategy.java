package org.example.strategy.parkingspot;

import org.example.enums.VehicleType;
import org.example.modals.EntryGate;
import org.example.modals.Floor;
import org.example.modals.ParkingSpot.ParkingSpot;

import java.util.List;

public interface ISpotAllocationStrategy {
    ParkingSpot findSpot(VehicleType vehicleType, List<Floor> floors, EntryGate entryGate);
}
