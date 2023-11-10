package ru.feoktistovvs.LogicalCircuit;

import ru.feoktistovvs.LogicalCircuit.components.EndGate;
import ru.feoktistovvs.LogicalCircuit.components.TriggerGate;
import ru.feoktistovvs.LogicalCircuit.components.StartGate;

import java.util.List;

public record LogicalCircuitContainer(List<StartGate> startGates,
                                      List<TriggerGate> triggerGates,
                                      List<EndGate> endGates) {
}
