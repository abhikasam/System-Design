package src.main.java.org.example.modals;

import src.main.java.org.example.enums.VehicleType;

public class TwoWheelerVehicle extends Vehicle{
    TwoWheelerVehicle(){
        super(VehicleType.TWO_WHEELER);
    }
    TwoWheelerVehicle(String vehicleNumber){
        super(vehicleNumber,VehicleType.TWO_WHEELER);
    }
}
