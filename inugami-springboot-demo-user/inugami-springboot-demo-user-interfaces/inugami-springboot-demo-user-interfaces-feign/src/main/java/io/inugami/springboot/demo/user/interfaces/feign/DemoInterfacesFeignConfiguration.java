package io.inugami.springboot.demo.user.interfaces.feign;

import io.inugami.maven.plugin.analysis.annotations.UsingFeignClient;
import org.springframework.context.annotation.Configuration;

@UsingFeignClient(feignConfigurationBean = DemoInterfacesFeignConfigurationClients.class)
@Configuration
public class DemoInterfacesFeignConfiguration {


}
