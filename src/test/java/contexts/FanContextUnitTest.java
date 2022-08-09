package contexts;

import enums.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import states.OffState;
import states.Speed1State;
import states.Speed2State;
import states.Speed3State;

public class FanContextUnitTest {

    private FanContext fanContext;

    @BeforeEach
    public void setup() {
        fanContext = new FanContextImpl();
    }

    @Test
    public void given_new_fan_the_state_is_off() {

        Assertions.assertEquals(fanContext.getState().getClass(), OffState.class);
    }

    @Test
    public void after_speed_0_the_state_is_1() {
        fanContext.nextState();

        Assertions.assertEquals(fanContext.getState().getClass(), Speed1State.class);
    }

    @Test
    public void after_speed_1_the_state_is_2() {
        fanContext.nextState();
        fanContext.nextState();

        Assertions.assertEquals(fanContext.getState().getClass(), Speed2State.class);
    }

    @Test
    public void after_speed_2_the_state_is_3() {
        fanContext.nextState();
        fanContext.nextState();
        fanContext.nextState();

        Assertions.assertEquals(fanContext.getState().getClass(), Speed3State.class);
    }

    @Test
    public void after_speed_3_the_state_is_off() {
        fanContext.nextState();
        fanContext.nextState();
        fanContext.nextState();
        fanContext.nextState();

        Assertions.assertEquals(fanContext.getState().getClass(), OffState.class);
    }

    @Test
    public void before_speed_0_the_state_is_3() {
        fanContext.previousState();

        Assertions.assertEquals(fanContext.getState().getClass(), Speed3State.class);
    }

    @Test
    public void before_speed_3_the_state_is_2() {
        fanContext.previousState();
        fanContext.previousState();

        Assertions.assertEquals(fanContext.getState().getClass(), Speed2State.class);
    }

    @Test
    public void before_speed_2_the_state_is_1() {
        fanContext.previousState();
        fanContext.previousState();
        fanContext.previousState();

        Assertions.assertEquals(fanContext.getState().getClass(), Speed1State.class);
    }

    @Test
    public void before_speed_1_the_state_is_off() {
        fanContext.previousState();
        fanContext.previousState();
        fanContext.previousState();
        fanContext.previousState();

        Assertions.assertEquals(fanContext.getState().getClass(), OffState.class);
    }

    @Test
    public void default_fan_direction_is_forward() {
        FanContext fanContext = new FanContextImpl();

        Assertions.assertEquals(fanContext.getDirection(), Direction.FORWARD);
    }

    @Test
    public void direction_is_reversed() {
        fanContext.setDirection(Direction.REVERSE);

        Assertions.assertEquals(fanContext.getDirection(), Direction.REVERSE);
    }
}
