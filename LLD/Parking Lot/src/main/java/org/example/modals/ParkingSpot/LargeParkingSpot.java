package org.example.modals.ParkingSpot;

import org.example.enums.ParkingSpotType;
import org.example.enums.VehicleType;

public class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot(){
        super();
        this.setPrize(80);
        this.setVehicleType(VehicleType.SIX_WHEELER);
        this.setParkingSpotType(ParkingSpotType.LARGE);

    }
}
