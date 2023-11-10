package ru.feoktistovvs.LogicalCircuit.components;

public class EndGate extends OneArgumentGate {

    private final int id;

    public EndGate(int id) {
        this.id = id;
    }

    @Override
    protected void calc() {
        super.setResult(super.getInput().getResult());
    }

    public boolean getResult() {
        return super.getResult();
    }

    public int getID() {
        return id;
    }

}
