package org.example.services;

import org.example.modals.EntryGate;
import org.example.modals.Ticket;
import org.example.modals.vehicle.Vehicle;

import java.util.List;

public class EntryGateService {
    List<EntryGate> entryGateList;
    public EntryGateService(List<EntryGate> entryGates){
        this.entryGateList = entryGates;
    }

    public Ticket park(Vehicle vehicle, EntryGate entryGate){
        return entryGate.park(vehicle);
    }
}
