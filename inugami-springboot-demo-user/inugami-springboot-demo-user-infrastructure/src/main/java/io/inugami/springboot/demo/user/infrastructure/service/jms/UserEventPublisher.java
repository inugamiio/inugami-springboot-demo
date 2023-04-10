package io.inugami.springboot.demo.user.infrastructure.service.jms;

import io.inugami.maven.plugin.analysis.annotations.JmsSender;
import io.inugami.springboot.demo.user.api.dto.UserDTO;
import io.inugami.springboot.demo.user.api.dto.event.CreatedUserEvent;
import io.inugami.springboot.demo.user.api.dto.event.DeletedUserEvent;
import io.inugami.springboot.demo.user.api.dto.event.UpdatedUserEvent;
import io.inugami.springboot.demo.user.api.service.IUserEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@RequiredArgsConstructor
@Service
public class UserEventPublisher implements IUserEventPublisher {

    private final JmsTemplate jmsTemplateQueue;
    private final Queue       createdUserQueue;
    private final Queue       updatedUserQueue;
    private final Queue       deletedUserQueue;


    @Override
    public void sendCreatedUser(final UserDTO user) {
        jmsTemplateQueue.convertAndSend(createdUserQueue, CreatedUserEvent.builder()
                                                                          .id(user.getId())
                                                                          .build());
    }

    @Override
    public void sendUpdatedUser(final UserDTO user) {
        jmsTemplateQueue.convertAndSend(updatedUserQueue, UpdatedUserEvent.builder()
                                                                          .id(user.getId())
                                                                          .build());
    }

    @Override
    public void sendDeletedUser(final UserDTO user) {
        jmsTemplateQueue.convertAndSend(deletedUserQueue, DeletedUserEvent.builder()
                                                                          .id(user.getId())
                                                                          .build());
    }
}
