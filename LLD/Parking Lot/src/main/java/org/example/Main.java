package org.example;

import org.example.modals.*;
import org.example.modals.ParkingSpot.LargeParkingSpot;
import org.example.modals.ParkingSpot.MediumParkingSpot;
import org.example.modals.ParkingSpot.SmallParkingSpot;
import org.example.modals.vehicle.TwoWheelerVehicle;
import org.example.modals.vehicle.Vehicle;
import org.example.services.EntryGateService;
import org.example.services.ExitGateService;
import org.example.services.ITicketService;
import org.example.services.TicketService;
import org.example.strategy.parkingspot.DefaultAllocationStrategy;
import org.example.strategy.parkingspot.ISpotAllocationStrategy;
import org.example.strategy.payment.CashPaymentStrategy;
import org.example.strategy.payment.IPaymentStrategy;
import org.example.strategy.price.IPricingStrategy;
import org.example.strategy.price.PricingStrategy;

import java.util.List;

public class Main {
    static void main() {
        IPricingStrategy pricingStrategy = new PricingStrategy();
        IPaymentStrategy paymentStrategy = new CashPaymentStrategy();
        ISpotAllocationStrategy spotAllocationStrategy = new DefaultAllocationStrategy();

        ITicketService ticketService = new TicketService();

        Floor floor = new Floor();
        for(int i=0;i<5;i++){
            floor.parkingSpots.add(new SmallParkingSpot());
            floor.parkingSpots.add(new MediumParkingSpot());
            floor.parkingSpots.add(new LargeParkingSpot());
        }
        ParkingLot parkingLot = new ParkingLot(spotAllocationStrategy, List.of(floor));
        EntryGate entryGate = new EntryGate(parkingLot, ticketService);
        ExitGate exitGate = new ExitGate(parkingLot, paymentStrategy, ticketService, pricingStrategy);

        EntryGateService entryGateService = new EntryGateService(List.of(entryGate));
        ExitGateService exitGateService = new ExitGateService(List.of(exitGate));

        Vehicle vehicle = new TwoWheelerVehicle("TS 19AH 1976");
        Ticket ticket = entryGateService.park(vehicle,entryGate);
        exitGateService.exit(ticket.getId(),exitGate);
    }
}
