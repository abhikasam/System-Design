package src.main.java.org.example.modals;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import src.main.java.org.example.enums.VehicleType;

@Data
public abstract class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
    Vehicle(){}
    Vehicle(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    Vehicle(String vehicleNumber,VehicleType vehicleType){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
}
