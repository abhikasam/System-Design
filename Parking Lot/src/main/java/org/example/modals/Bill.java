package org.example.modals;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public record Bill (
        LocalDateTime entryTime,
        LocalDateTime exitTime,
        long fee) {
    public static Bill create(Ticket ticket,int price){
        LocalDateTime endTime = LocalDateTime.now();
        long hours = ChronoUnit.HOURS.between(ticket.entryTime, endTime);
        return new Bill(ticket.entryTime,endTime,price*hours);
    }
}
