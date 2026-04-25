package src.main.java.org.example.modals;

import src.main.java.org.example.enums.VehicleType;

import java.util.UUID;

public class MediumParkingSpot extends ParkingSpot {
    public MediumParkingSpot(){
        this.setId(UUID.randomUUID().toString());
        this.setPrize(50);
        this.setVehicleType(VehicleType.FOUR_WHEELER);
    }
}
