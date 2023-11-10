package ru.feoktistovvs.LogicalCircuit;

import ru.feoktistovvs.LogicalCircuit.components.EndGate;
import ru.feoktistovvs.LogicalCircuit.components.TriggerGate;
import ru.feoktistovvs.LogicalCircuit.components.StartGate;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class LogicalCircuitEngine {

    private LogicalCircuitResult result;

    private final LogicalCircuitCreator logicalCircuitCreator;

    private boolean isEvenStarted = false;

    public LogicalCircuitEngine(LogicalCircuitCreator logicalCircuitCreator) {
        this.logicalCircuitCreator = logicalCircuitCreator;
    }

    private void compute(Map<Integer, Boolean> startsValues, Map<Integer, Boolean> triggersValues) {
        var container = logicalCircuitCreator.createLogicalCircuit();

        container.triggerGates().forEach(gate ->
                gate.setStartValue(triggersValues.get(gate.getID()))
        );
        container.startGates().forEach(gate ->
                gate.setStartValue(startsValues.get(gate.getID()))
        );

        container.triggerGates().forEach(TriggerGate::start);
        container.startGates().forEach(StartGate::start);

        Map<Integer, Boolean> newTriggersValues = container
                .triggerGates()
                .stream()
                .collect(Collectors.toMap(
                        TriggerGate::getID, TriggerGate::getNewValue
                ));
        Map<Integer, Boolean> outputValues = container
                .endGates()
                .stream()
                .collect(Collectors.toMap(
                        EndGate::getID, EndGate::getResult
                ));
        result.outputValuesSequence().add(outputValues);
        result.triggersValuesSequence().add(newTriggersValues);
    }

    public void start(Map<Integer, Boolean> startsValues, Map<Integer, Boolean> triggersValues) {
        if(isEvenStarted)
            throw new RuntimeException("The logic circuit has been already started!");
        result = new LogicalCircuitResult(new ArrayList<>(), new ArrayList<>());
        compute(startsValues, triggersValues);
        isEvenStarted = true;
    }

    public void next(Map<Integer, Boolean> startsValues) {
        if(!isEvenStarted)
            throw new RuntimeException("The logic circuit has never been started yet!");

        Map<Integer, Boolean> triggersValues = result.triggersValuesSequence()
                .get(result.triggersValuesSequence().size() - 1);
        compute(startsValues, triggersValues);
    }

    public LogicalCircuitResult getResult() {
        return result;
    }

}
