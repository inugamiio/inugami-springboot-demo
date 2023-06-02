package io.inugami.springboot.demo.user.search.infrastructure.configuration;

import io.inugami.springboot.demo.user.interfaces.feign.DemoInterfacesFeignConfigurationClients;
import org.springframework.context.annotation.Configuration;

import io.inugami.maven.plugin.analysis.annotations.UsingFeignClient;

@UsingFeignClient(feignConfigurationBean = DemoInterfacesFeignConfigurationClients.class)
@Configuration
public class InfrastructureConfiguration {
}
