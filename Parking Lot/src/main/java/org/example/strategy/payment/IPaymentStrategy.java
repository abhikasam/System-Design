package src.main.java.org.example.strategy.payment;

import src.main.java.org.example.modals.Bill;
import src.main.java.org.example.modals.Ticket;

public interface IPaymentStrategy {
    Bill process(Ticket ticket);
}
