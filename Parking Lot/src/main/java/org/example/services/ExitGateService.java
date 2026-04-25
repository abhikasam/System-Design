package src.main.java.org.example.services;

import src.main.java.org.example.modals.Bill;
import src.main.java.org.example.modals.ExitGate;

import java.util.List;

public class ExitGateService {
    List<ExitGate> exitGates;
    public ExitGateService(List<ExitGate> exitGates){
        this.exitGates = exitGates;
    }
    Bill exit(String id,ExitGate gate){
        return gate.release(id);
    }

}
