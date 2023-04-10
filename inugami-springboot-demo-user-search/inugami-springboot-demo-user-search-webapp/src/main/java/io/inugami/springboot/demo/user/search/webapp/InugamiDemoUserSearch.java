package io.inugami.springboot.demo.user.search.webapp;

import io.inugami.monitoring.springboot.config.InugamiMonitoringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "io.inugami.springboot.demo",
        InugamiMonitoringConfig.INUGAMI_MONITORING_CONFIG
})
@SpringBootApplication
public class InugamiDemoUserSearch {

    public static void main(final String[] args) {
        SpringApplication.run(InugamiDemoUserSearch.class, args);
    }

}
