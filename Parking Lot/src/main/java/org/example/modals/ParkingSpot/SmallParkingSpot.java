package src.main.java.org.example.modals.ParkingSpot;

import src.main.java.org.example.enums.ParkingSpotType;
import src.main.java.org.example.enums.VehicleType;

public class SmallParkingSpot extends ParkingSpot {
    public SmallParkingSpot(){
        super();
        this.setPrize(20);
        this.setVehicleType(VehicleType.TWO_WHEELER);
        this.setParkingSpotType(ParkingSpotType.SMALL);
    }
}
