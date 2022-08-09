package services;

import contexts.FanContext;
import enums.Direction;

public class FanServiceImpl implements FanService {

    private final FanContext fanContext;

    public FanServiceImpl(FanContext fanContext) {
        this.fanContext = fanContext;
    }

    @Override
    public void changeSpeed() {
        if (fanContext.getDirection() == Direction.FORWARD) {
            // fanContext.getState().next(fanContext);
            fanContext.nextState();
        } else {
            // fanContext.getState().prev(fanContext);
            fanContext.previousState();
        }
    }

    @Override
    public void changeDirection() {
        if (fanContext.getDirection() == Direction.FORWARD) {
            fanContext.setDirection(Direction.REVERSE);
        } else {
            fanContext.setDirection(Direction.FORWARD);
        }
    }
}
