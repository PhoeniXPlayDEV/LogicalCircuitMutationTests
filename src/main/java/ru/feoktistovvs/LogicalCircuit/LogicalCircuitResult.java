package ru.feoktistovvs.LogicalCircuit;

import java.util.List;
import java.util.Map;

public record LogicalCircuitResult(List<Map<Integer, Boolean>> outputValuesSequence, List<Map<Integer, Boolean>> triggersValuesSequence) {

}
