package states;

import contexts.FanContext;

public class Speed1State implements FanState {

    String status = "fan is on speed 1";

    @Override
    public void prev(FanContext fanContext) {
        fanContext.setState(new OffState());
    }

    @Override
    public void next(FanContext fanContext) {
        fanContext.setState(new Speed2State());
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
        return this.status + " - Speed1State{}";
    }
}
