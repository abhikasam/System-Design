package org.example.modals;

import org.example.modals.ParkingSpot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    static int id;
    public List<ParkingSpot> parkingSpots;
    public Floor(){
        this.parkingSpots = new ArrayList<>();
    }
    public Floor(List<ParkingSpot> parkingSpots){
        this.parkingSpots = parkingSpots;
    }
}
