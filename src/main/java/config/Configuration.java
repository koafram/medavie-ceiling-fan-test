package config;

import contexts.FanContext;
import contexts.FanContextImpl;
import services.FanService;
import services.FanServiceImpl;

public class Configuration {

    public final static FanContext fanContext =  new FanContextImpl();
    public final static FanService fanService = new FanServiceImpl(fanContext);
}
