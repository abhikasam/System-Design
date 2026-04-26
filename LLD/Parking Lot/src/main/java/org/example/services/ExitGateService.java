package org.example.services;

import org.example.modals.Bill;
import org.example.modals.ExitGate;

import java.util.List;

public class ExitGateService {
    List<ExitGate> exitGates;
    public ExitGateService(List<ExitGate> exitGates){
        this.exitGates = exitGates;
    }
    public Bill exit(String id, ExitGate gate){
        return gate.exit(id);
    }
}
