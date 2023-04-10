package io.inugami.springboot.demo.user.search.interfaces.config;

import io.inugami.commons.marshaling.jaxb.JaxbClassRegister;
import io.inugami.springboot.demo.user.search.api.dto.event.CreatedUserEvent;
import io.inugami.springboot.demo.user.search.api.dto.event.DeletedUserEvent;
import io.inugami.springboot.demo.user.search.api.dto.event.UpdatedUserEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JmsConfiguration {
    public static final String QUEUE_USER_CREATED = "user-created";
    public static final String QUEUE_USER_UPDATED = "user-updated";
    public static final String QUEUE_USER_DELETED = "user-deleted";

    @Bean
    public JaxbClassRegister demoEvents() {
        return () -> List.of(
                CreatedUserEvent.class,
                UpdatedUserEvent.class,
                DeletedUserEvent.class
        );
    }

}
