package contexts;

import enums.Direction;
import states.FanState;

public interface FanContext {

    FanState getState();

    void setState(FanState state);

    void previousState();

    void nextState();

    void printStatus();

    Direction getDirection();

    void setDirection(Direction direction);
}
