package org.example.enums;

public enum VehicleType {
    TWO_WHEELER,FOUR_WHEELER, SIX_WHEELER;
    public ParkingSpotType getParkingSpotType(){
        return switch (this) {
            case TWO_WHEELER -> ParkingSpotType.SMALL;
            case FOUR_WHEELER -> ParkingSpotType.MEDIUM;
            case SIX_WHEELER -> ParkingSpotType.LARGE;
        };
    }
}
