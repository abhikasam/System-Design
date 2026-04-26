package org.example.modals;

import org.example.modals.ParkingSpot.ParkingSpot;
import org.example.modals.vehicle.Vehicle;
import org.example.services.ITicketService;
import org.example.strategy.payment.IPaymentStrategy;

import java.time.LocalDateTime;

public class ExitGate {
    ParkingLot parkingLot;
    ITicketService ticketService;
    IPaymentStrategy paymentStrategy;
    public ExitGate(ParkingLot parkingLot,IPaymentStrategy paymentStrategy,ITicketService ticketService){
        this.parkingLot = parkingLot;
        this.paymentStrategy = paymentStrategy;
        this.ticketService = ticketService;
    }
    public Bill release(String id){
        Ticket ticket = ticketService.getTicket(id);
        parkingLot.release(ticket.parkingSpot);
        ticket.setExitTime(LocalDateTime.now());
        ticketService.remove(ticket.id);
        return paymentStrategy.process(ticket);
    }
}
