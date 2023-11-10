package ru.feoktistovvs.CustomMutations;

import ru.feoktistovvs.LogicalCircuit.LogicalCircuitContainer;
import ru.feoktistovvs.LogicalCircuit.LogicalCircuitCreator;
import ru.feoktistovvs.LogicalCircuit.components.*;

import java.util.List;

public class CustomMutation15 extends LogicalCircuitCreator {

    @Override
    public LogicalCircuitContainer createLogicalCircuit() {
        StartGate startGate = new StartGate(1);
        TriggerGate triggerGate1 = new TriggerGate(1);
        TriggerGate triggerGate2 = new TriggerGate(2);
        ConjunctionGate conjunctionGate1 = new ConjunctionGate();
        ConjunctionGate conjunctionGate2 = new ConjunctionGate();
        InverterGate inverterGate1 = new InverterGate();
        InverterGate inverterGate2 = new InverterGate();
        EndGate endGate = new EndGate(1);

        inverterGate1.setInput(startGate);
        conjunctionGate1.setInput1(inverterGate1);
        conjunctionGate1.setInput2(triggerGate1);
        inverterGate2.setInput(conjunctionGate1);
        triggerGate1.setInput(inverterGate2);

        //Changed the argument name from conjunctionGate1 to conjunctionGate2
        triggerGate2.setInput(conjunctionGate2);

        conjunctionGate2.setInput1(triggerGate2);
        conjunctionGate2.setInput2(inverterGate1);
        endGate.setInput(conjunctionGate2);

        List<StartGate> startGates = List.of(startGate);
        List<TriggerGate> triggerGates = List.of(triggerGate1, triggerGate2);
        List<EndGate> endGates = List.of(endGate);

        return new LogicalCircuitContainer(startGates, triggerGates, endGates);
    }

}
