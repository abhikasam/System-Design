package src.main.java.org.example.modals;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<ParkingSpot> parkingSpots;
    ParkingLot(){
        this.parkingSpots = new ArrayList<>();
    }
    void addSpot(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    void removeSpot(ParkingSpot parkingSpot){
        this.parkingSpots.remove(parkingSpot);
    }

    public Ticket park(Vehicle vehicle) {
        return new Ticket();
    }
}
