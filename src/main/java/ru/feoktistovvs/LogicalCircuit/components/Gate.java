package ru.feoktistovvs.LogicalCircuit.components;

import java.util.ArrayList;
import java.util.List;

public abstract class Gate {

    private boolean result;
    private boolean hasResultChanged;
    private int gatesLeft;
    private final List<Gate> output = new ArrayList<>();
    public final void signal() {
        gatesLeft--;
        if(gatesLeft < 0)
            throw new RuntimeException("Fatal error! Negative gate counter!");
        if (this instanceof TriggerGate) {
            calc();
            return;
        }
        if (gatesLeft == 0)
            execute();
    }

    protected final void execute() {
        calc();
        output.forEach(Gate::signal);
    }

    protected abstract void calc();

    protected boolean getResult() {
        if(!hasResultChanged)
            throw new RuntimeException("The gate has never been updated!");
        return result;
    }

    protected final void setResult(boolean result) {
        this.result = result;
        this.hasResultChanged = true;
    }

    protected final void setGatesLeft(int gatesLeft) {
        this.gatesLeft = gatesLeft;
    }

    protected final void addGateOutput(Gate gate) {
        output.add(gate);
    }

    protected final List<Gate> getGateOutput() {
        return output;
    }

}
