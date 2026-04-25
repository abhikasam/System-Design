package src.main.java.org.example.strategy.payment;

import src.main.java.org.example.modals.Bill;
import src.main.java.org.example.modals.Ticket;

public class CashPaymentStrategy implements IPaymentStrategy {
    @Override
    public Bill process(Ticket ticket) {
        return Bill.create(ticket);
    }
}
