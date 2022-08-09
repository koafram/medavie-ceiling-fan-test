package states;

import contexts.FanContext;

public class OffState implements FanState {

    String status = "fan is off";

    @Override
    public void prev(FanContext fanContext) {
        fanContext.setState(new Speed3State());
    }

    @Override
    public void next(FanContext fanContext) {
        fanContext.setState(new Speed1State());
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public void printStatus() {
        System.out.println("The " + status + ".");
    }

    @Override
    public String toString() {
        return this.status + " - OffState{}";
    }
}
