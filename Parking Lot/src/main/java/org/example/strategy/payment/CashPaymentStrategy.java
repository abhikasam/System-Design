package org.example.strategy.payment;

import org.example.modals.Bill;
import org.example.modals.Ticket;

public class CashPaymentStrategy implements IPaymentStrategy {
    @Override
    public Bill process(Ticket ticket) {
        return Bill.create(ticket);
    }
}
