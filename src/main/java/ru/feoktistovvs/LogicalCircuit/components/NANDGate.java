package ru.feoktistovvs.LogicalCircuit.components;

public class NANDGate extends TwoArgumentsGate {

    @Override
    protected void calc() {
        super.setResult(!(super.getInput1().getResult() &
                super.getInput2().getResult()));
    }

}
