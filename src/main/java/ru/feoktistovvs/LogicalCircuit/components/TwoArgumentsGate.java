package ru.feoktistovvs.LogicalCircuit.components;

public abstract class TwoArgumentsGate extends Gate {

    private Gate input1;
    private Gate input2;

    public TwoArgumentsGate(){
        super.setGatesLeft(2);
    }

    protected final Gate getInput1() {
        return input1;
    }

    public final void setInput1(Gate input) {
        if(this.input1 != null)
            this.input1.getGateOutput().remove(this);
        this.input1 = input;
        this.input1.addGateOutput(this);
    }

    protected final Gate getInput2() {
        return input2;
    }

    public final void setInput2(Gate input) {
        if(this.input2 != null)
            this.input2.getGateOutput().remove(this);
        this.input2 = input;
        this.input2.addGateOutput(this);
    }

}
