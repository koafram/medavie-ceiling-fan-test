package services;

import contexts.FanContext;
import contexts.FanContextImpl;
import enums.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import states.OffState;
import states.Speed2State;
import states.Speed3State;

public class FanServiceUnitTest {

    private FanContext fanContext;
    private services.FanService fanService;

    @BeforeEach
    public void setup() {
        fanContext = new FanContextImpl();
        fanService = new services.FanServiceImpl(fanContext);
    }

    @Test
    public void given_new_fan_the_state_is_off() {
        Assertions.assertEquals(fanContext.getState().getClass(), OffState.class);
    }

    @Test
    public void direction_is_in_reverse() {
        fanService.changeDirection();

        Assertions.assertEquals(fanContext.getDirection(), Direction.REVERSE);
    }

    @Test
    public void cord_to_change_direction_is_pulled_once_and_change_speed_pulled_once() {
        fanService.changeDirection();
        fanService.changeSpeed();

        Assertions.assertEquals(fanContext.getState().getClass(), Speed3State.class);
    }

    @Test
    public void cord_to_change_speed_is_pulled_twice() {
        fanService.changeSpeed();
        fanService.changeSpeed();

        Assertions.assertEquals(fanContext.getState().getClass(), Speed2State.class);
    }

    @Test
    public void cord_to_change_direction_is_pulled_twice_and_change_speed_pulled_twice() {
        fanService.changeDirection();
        fanService.changeDirection();
        fanService.changeSpeed();
        fanService.changeSpeed();

        Assertions.assertEquals(fanContext.getState().toString(), "fan is on speed 2 - Speed2State{}");
    }
}
