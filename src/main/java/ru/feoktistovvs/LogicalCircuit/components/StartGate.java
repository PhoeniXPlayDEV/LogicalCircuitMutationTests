package ru.feoktistovvs.LogicalCircuit.components;

public class StartGate extends OneArgumentGateWithStartValue {

    public StartGate(int id) {
        super(id);
    }

    @Override
    protected void calc() { }

    public void start() {
        super.execute();
    }

}
