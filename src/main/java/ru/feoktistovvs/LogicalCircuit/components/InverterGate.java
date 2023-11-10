package ru.feoktistovvs.LogicalCircuit.components;

public class InverterGate extends OneArgumentGate {

    @Override
    protected void calc() {
        super.setResult(!super.getInput().getResult());
    }

}
