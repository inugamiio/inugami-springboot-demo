package io.inugami.springboot.demo.user.infrastructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "io.inugami.springboot.demo.user.infrastructure")
@EntityScan(basePackages = "io.inugami.springboot.demo.user.infrastructure")
@EnableTransactionManagement
@Configuration
public class DatasourceConfiguration {
}
