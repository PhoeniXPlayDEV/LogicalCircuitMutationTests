package ru.feoktistovvs.LogicalCircuit.components;

public class TriggerGate extends OneArgumentGateWithStartValue {
    private boolean newValue;

    public TriggerGate(int id) {
        super(id);
    }

    @Override
    protected void calc() {
        newValue = super.getInput().getResult();
    }

    public void start() {
        super.getGateOutput().forEach(Gate::signal);
    }

    public boolean getNewValue() {
        return newValue;
    }

}
