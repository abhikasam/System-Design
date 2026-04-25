package src.main.java.org.example.modals.vehicle;

import src.main.java.org.example.enums.VehicleType;

public class SixWheelerVehicle extends Vehicle {
    SixWheelerVehicle(){
        super(VehicleType.SIX_WHEELER);
    }
    SixWheelerVehicle(String number){
        super(number,VehicleType.SIX_WHEELER);
    }
}
