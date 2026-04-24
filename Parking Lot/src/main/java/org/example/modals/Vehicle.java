package src.main.java.org.example.modals;

import src.main.java.org.example.enums.VehicleType;

public abstract class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
    Vehicle(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    Vehicle(String vehicleNumber,VehicleType vehicleType){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
}
