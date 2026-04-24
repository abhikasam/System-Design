package src.main.java.org.example.modals;

import src.main.java.org.example.enums.VehicleType;

public class FourWheelerVehicle extends Vehicle {
    FourWheelerVehicle(){
        super(VehicleType.FOUR_WHEELER);
    }

    FourWheelerVehicle(String number){
        super(number,VehicleType.FOUR_WHEELER);
    }
}
