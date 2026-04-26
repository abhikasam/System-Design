package org.example.strategy.price;

import org.example.modals.Ticket;

public interface IPricingStrategy {
    int calculate(Ticket ticket);
}
