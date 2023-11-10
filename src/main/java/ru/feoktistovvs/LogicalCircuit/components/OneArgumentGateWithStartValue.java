package ru.feoktistovvs.LogicalCircuit.components;

public abstract class OneArgumentGateWithStartValue extends OneArgumentGate {

    private final int id;

    public OneArgumentGateWithStartValue(int id) {
        this.id = id;
    }

    public void setStartValue(boolean value) {
        super.setResult(value);
    }

    public int getID() {
        return id;
    }

//    @Override
//    public int compareTo(OneArgumentGateWithStartValue o) {
//        return id - o.getID();
//    }

}
