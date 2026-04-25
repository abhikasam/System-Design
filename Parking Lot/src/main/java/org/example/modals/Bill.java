package src.main.java.org.example.modals;

import java.time.LocalDateTime;

public record Bill (
        LocalDateTime entryTime,
        LocalDateTime exitTime,
        int fee) {
    public static Bill create(Ticket ticket){
        return new Bill(ticket.entryTime(),ticket.exitTime(),ticket.fee());
    }
}
