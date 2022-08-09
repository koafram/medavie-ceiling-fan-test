package states;

import contexts.FanContext;

public interface FanState {

    void prev(FanContext FanContext);

    void next(FanContext FanContext);

    String getStatus();

    void printStatus();
}
