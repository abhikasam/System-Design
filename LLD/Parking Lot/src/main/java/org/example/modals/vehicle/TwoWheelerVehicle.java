package org.example.modals.vehicle;

import org.example.enums.VehicleType;

public class TwoWheelerVehicle extends Vehicle {
    TwoWheelerVehicle(){
        super(VehicleType.TWO_WHEELER);
    }
    public TwoWheelerVehicle(String vehicleNumber){
        super(vehicleNumber,VehicleType.TWO_WHEELER);
    }
}
