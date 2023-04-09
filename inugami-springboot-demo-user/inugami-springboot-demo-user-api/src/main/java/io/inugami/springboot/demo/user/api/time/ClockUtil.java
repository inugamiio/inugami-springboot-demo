package io.inugami.springboot.demo.user.api.time;

import java.time.Clock;

public final class ClockUtil {

    public static Clock getClock(){
        return Clock.systemDefaultZone();
    }
}
