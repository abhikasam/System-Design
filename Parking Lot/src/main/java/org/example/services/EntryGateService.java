package src.main.java.org.example.services;

import src.main.java.org.example.modals.EntryGate;
import src.main.java.org.example.modals.Ticket;
import src.main.java.org.example.modals.vehicle.Vehicle;

import java.util.List;

public class EntryGateService {
    List<EntryGate> entryGateList;
    public EntryGateService(List<EntryGate> entryGates){
        this.entryGateList = entryGates;
    }

    Ticket park(Vehicle vehicle,EntryGate entryGate){
        return entryGate.park(vehicle);
    }
}
