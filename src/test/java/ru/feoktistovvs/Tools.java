package ru.feoktistovvs;

import ru.feoktistovvs.LogicalCircuit.LogicalCircuitCreator;
import ru.feoktistovvs.LogicalCircuit.LogicalCircuitEngine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tools {

    public static List<Map<Integer, Boolean>> formValuesSequence(String input) {
        return Arrays.stream(input.split(":")).map(Tools::formLogicValues)
                .collect(Collectors.toList());
    }

    public static Map<Integer, Boolean> formTriggersValues(String input) {
        return formLogicValues(input);
    }

    public static Map<Integer, Boolean> formLogicValues(String input) {
        return IntStream.rangeClosed(0, input.length() - 1).boxed().collect(Collectors.toMap(
                i -> i + 1, i -> logicValueByChar(input.charAt(i))
        ));
    }

    public static boolean logicValueByChar(char value) {
        return switch (value) {
            case '0' -> { yield false; }
            case '1' -> { yield true; }
            default -> throw new IllegalArgumentException();
        };
    }

}
