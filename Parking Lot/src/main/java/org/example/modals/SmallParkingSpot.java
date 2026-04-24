package src.main.java.org.example.modals;

import src.main.java.org.example.enums.VehicleType;

import java.util.UUID;

public class SmallParkingSpot extends ParkingSpot{
    SmallParkingSpot(){
        this.setId(UUID.randomUUID().toString());
        this.setPrize(20);
        this.setVehicleType(VehicleType.TWO_WHEELER);
    }
}
