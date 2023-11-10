package ru.feoktistovvs;

import org.junit.jupiter.api.Assertions;
import ru.feoktistovvs.LogicalCircuit.LogicalCircuitCreator;
import ru.feoktistovvs.LogicalCircuit.LogicalCircuitEngine;

import java.util.List;
import java.util.Map;

public class TestingSystem {

    public static void testAllInputSequences(LogicalCircuitCreator creator,
                                             boolean isCustomMutationTest
    ) {
        List<Boolean> testResults = List.of(
                testInputSequenceW1(creator),
                testInputSequenceW2(creator),
                testInputSequenceW3(creator),
                testInputSequenceW4(creator)
        );

        if(isCustomMutationTest)
            Assertions.assertTrue(testResults.stream().anyMatch(res -> !res));
        else
            Assertions.assertTrue(testResults.stream().allMatch(res -> res));
    }

    public static boolean testInputSequences(
            LogicalCircuitCreator creator,
            List<Map<Integer, Boolean>> startsValuesSequence,
            Map<Integer, Boolean> triggersValues,
            List<Map<Integer, Boolean>> outputSequence
    ) {
        LogicalCircuitEngine logicalCircuit = new LogicalCircuitEngine(creator);
        var iter = startsValuesSequence.iterator();
        var startsValues = iter.next();
        logicalCircuit.start(startsValues, triggersValues);
        while (iter.hasNext()) {
            startsValues = iter.next();
            logicalCircuit.next(startsValues);
        }
        return outputSequence.equals(logicalCircuit.getResult().outputValuesSequence());
    }

    //Test sequence from W-method: 0/0 0/0 0/1 0/0 0/1
    private static boolean testInputSequenceW1(LogicalCircuitCreator creator) {
        return testInputSequences(creator,
                Tools.formValuesSequence("0:0:0:0:0"),
                Tools.formTriggersValues("00"),
                Tools.formValuesSequence("0:0:1:0:1"));
    }

    //Test sequence from W-method: 0/0 0/0 1/0 0/0 0/1
    private static boolean testInputSequenceW2(LogicalCircuitCreator creator) {
        return testInputSequences(creator,
                Tools.formValuesSequence("0:0:1:0:0"),
                Tools.formTriggersValues("00"),
                Tools.formValuesSequence("0:0:0:0:1"));
    }

    //Test sequence from W-method: 0/0 1/0 0/0 0/1
    private static boolean testInputSequenceW3(LogicalCircuitCreator creator) {
        return testInputSequences(creator,
                Tools.formValuesSequence("0:1:0:0"),
                Tools.formTriggersValues("00"),
                Tools.formValuesSequence("0:0:0:1"));
    }

    //Test sequence from W-method: 1/0 0/0 0/1
    private static boolean testInputSequenceW4(LogicalCircuitCreator creator) {
        return testInputSequences(creator,
                Tools.formValuesSequence("1:0:0"),
                Tools.formTriggersValues("00"),
                Tools.formValuesSequence("0:0:1"));
    }

}
