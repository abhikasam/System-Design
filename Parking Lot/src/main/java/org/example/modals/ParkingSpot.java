package src.main.java.org.example.modals;

import lombok.Data;
import src.main.java.org.example.enums.VehicleType;

@Data
public abstract class ParkingSpot {
    String id;
    Vehicle vehicle;
    VehicleType vehicleType;
    boolean isFree;
    int prize;
    ParkingSpot(){}
    void allocate(Vehicle vehicle){
        if(vehicle.getVehicleType()==vehicleType){
            setVehicle(vehicle);
            setFree(false);
        }
        throw new UnsupportedOperationException("Vehicle Type mismatch");
    }

    void release(){
        if(!isFree){
            setVehicle(null);
            setFree(true);
        }
    }
}
