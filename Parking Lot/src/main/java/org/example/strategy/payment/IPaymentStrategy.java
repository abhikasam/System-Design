package org.example.strategy.payment;

import org.example.modals.Bill;
import org.example.modals.Ticket;

public interface IPaymentStrategy {
    Bill process(Ticket ticket);
}
