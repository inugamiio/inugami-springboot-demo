package io.inugami.springboot.demo.user.infrastructure.configuration;

import io.inugami.commons.marshaling.jaxb.JaxbClassRegister;
import io.inugami.springboot.demo.user.api.dto.event.CreatedUserEvent;
import io.inugami.springboot.demo.user.api.dto.event.DeletedUserEvent;
import io.inugami.springboot.demo.user.api.dto.event.UpdatedUserEvent;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.jms.Queue;
import java.util.List;

@EnableJms
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

    @Bean
    public Queue createdUserQueue() {
        return new ActiveMQQueue(QUEUE_USER_CREATED);
    }

    @Bean
    public Queue updatedUserQueue() {
        return new ActiveMQQueue(QUEUE_USER_UPDATED);
    }

    @Bean
    public Queue deletedUserQueue() {
        return new ActiveMQQueue(QUEUE_USER_DELETED);
    }
}
