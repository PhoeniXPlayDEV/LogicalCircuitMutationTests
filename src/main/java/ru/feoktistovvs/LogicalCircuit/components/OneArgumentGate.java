package ru.feoktistovvs.LogicalCircuit.components;

public abstract class OneArgumentGate extends Gate {

    private Gate input;

    public OneArgumentGate(){
        super.setGatesLeft(1);
    }

    protected final Gate getInput() {
        return input;
    }

    public final void setInput(Gate input) {
        if(this.input != null)
            this.input.getGateOutput().remove(this);
        this.input = input;
        this.input.addGateOutput(this);
    }

}
