package org.example.modals.ParkingSpot;

import org.example.enums.ParkingSpotType;
import org.example.enums.VehicleType;

public class MediumParkingSpot extends ParkingSpot {
    public MediumParkingSpot(){
        super();
        this.setPrize(50);
        this.setVehicleType(VehicleType.FOUR_WHEELER);
        this.setParkingSpotType(ParkingSpotType.MEDIUM);
    }
}
