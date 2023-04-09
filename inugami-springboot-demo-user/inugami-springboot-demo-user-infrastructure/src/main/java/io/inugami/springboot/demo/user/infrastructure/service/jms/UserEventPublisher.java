package io.inugami.springboot.demo.user.infrastructure.service.jms;

import io.inugami.springboot.demo.user.api.dto.UserDTO;
import io.inugami.springboot.demo.user.api.service.IUserEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserEventPublisher implements IUserEventPublisher {
    @Override
    public void sendCreatedUser(final UserDTO user) {

    }

    @Override
    public void sendUpdatedUser(final UserDTO user) {

    }

    @Override
    public void sendDeletedUser(final UserDTO user) {

    }
}
