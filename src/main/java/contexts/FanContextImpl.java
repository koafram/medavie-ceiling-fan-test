package contexts;

import enums.Direction;
import states.FanState;
import states.OffState;

public class FanContextImpl implements FanContext {

    private Direction direction = Direction.FORWARD;
    private FanState state = new OffState();

    @Override
    public FanState getState() {
        return state;
    }

    @Override
    public void setState(FanState state) {
        this.state = state;
    }

    @Override
    public void previousState() {
        state.prev(this);
    }

    @Override
    public void nextState() {
        state.next(this);
    }

    @Override
    public void printStatus() {
        String status = "The " + this.state.getStatus();

        if (!status.contains("off")) {
            status += " and is moving in the " + this.direction.getLabel() + " direction.";
        } else {
            status += " but will be moving in the " + this.direction.getLabel() + " direction when turned on again.";
        }

        System.out.println(status);
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
