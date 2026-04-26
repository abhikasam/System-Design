package org.example.modals;

import org.example.services.ITicketService;
import org.example.strategy.payment.IPaymentStrategy;
import org.example.strategy.price.IPricingStrategy;

import java.time.LocalDateTime;

public class ExitGate {
    ParkingLot parkingLot;
    ITicketService ticketService;
    IPaymentStrategy paymentStrategy;
    IPricingStrategy pricingStrategy;
    public ExitGate(ParkingLot parkingLot,IPaymentStrategy paymentStrategy,ITicketService ticketService,IPricingStrategy pricingStrategy){
        this.parkingLot = parkingLot;
        this.paymentStrategy = paymentStrategy;
        this.ticketService = ticketService;
        this.pricingStrategy = pricingStrategy;
    }
    public Bill exit(String id){
        Ticket ticket = ticketService.getTicket(id);
        parkingLot.release(ticket);
        ticket.setExitTime(LocalDateTime.now());
        int price = pricingStrategy.calculate(ticket);
        Bill bill = Bill.create(ticket,price);
        paymentStrategy.pay(bill);
        ticketService.remove(ticket.id);
        return bill;
    }
}
