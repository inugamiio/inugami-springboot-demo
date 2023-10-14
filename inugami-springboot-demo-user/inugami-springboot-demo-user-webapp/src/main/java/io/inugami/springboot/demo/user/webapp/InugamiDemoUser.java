package io.inugami.springboot.demo.user.webapp;

import io.inugami.monitoring.springboot.config.InugamiMonitoringConfig;
import io.inugami.springboot.demo.user.api.time.ClockUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.Clock;

@ComponentScan(basePackages = {
        "io.inugami.springboot.demo",
        InugamiMonitoringConfig.INUGAMI_MONITORING_CONFIG
})
@SpringBootApplication
public class InugamiDemoUser {

    public static void main(final String[] args) {
        SpringApplication.run(InugamiDemoUser.class, args);
    }

    @Bean
    public Clock clock() {
        return ClockUtil.getClock();
    }
}
