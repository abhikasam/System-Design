package src.main.java.org.example.modals.ParkingSpot;

import lombok.Data;
import src.main.java.org.example.enums.ParkingSpotType;
import src.main.java.org.example.enums.VehicleType;
import src.main.java.org.example.modals.vehicle.Vehicle;

import java.util.UUID;

@Data
public abstract class ParkingSpot {
    String id;
    Vehicle vehicle;
    VehicleType vehicleType;
    ParkingSpotType parkingSpotType;
    boolean isFree;
    int prize;
    ParkingSpot(){
        this.setId(UUID.randomUUID().toString());
    }
    public void allocate(Vehicle vehicle){
        if(vehicle.getVehicleType()==vehicleType){
            setVehicle(vehicle);
            setFree(false);
        }
        throw new UnsupportedOperationException("Vehicle Type mismatch");
    }

    public void release(){
        if(!isFree){
            setVehicle(null);
            setFree(true);
        }
    }
}
