package org.example.modals.vehicle;

import lombok.Data;
import org.example.enums.VehicleType;

@Data
public abstract class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
    public Vehicle(){}
    Vehicle(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    Vehicle(String vehicleNumber,VehicleType vehicleType){
        setVehicleNumber(vehicleNumber);
        setVehicleType(vehicleType);
    }
}
