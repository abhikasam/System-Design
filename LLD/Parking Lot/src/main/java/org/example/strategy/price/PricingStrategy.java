package org.example.strategy.price;

import org.example.enums.ParkingSpotType;
import org.example.modals.Ticket;

public class PricingStrategy implements IPricingStrategy{
    @Override
    public int calculate(Ticket ticket) {
        ParkingSpotType parkingSpotType = ticket.getParkingSpot().getParkingSpotType();
        if(parkingSpotType == ParkingSpotType.SMALL)
            return 20;
        else if(parkingSpotType == ParkingSpotType.MEDIUM)
            return 50;
        else if(parkingSpotType == ParkingSpotType.LARGE)
            return 80;
        return 0;
    }
}
