package io.inugami.springboot.demo.user.search.interfaces.jms;

import io.inugami.monitoring.springboot.activemq.config.InugamiActiveMqConfig;
import io.inugami.springboot.demo.user.search.api.IUserSearchService;
import io.inugami.springboot.demo.user.search.api.dto.event.CreatedUserEvent;
import io.inugami.springboot.demo.user.search.api.dto.event.DeletedUserEvent;
import io.inugami.springboot.demo.user.search.interfaces.config.JmsConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSearchJmsListener {

    private final IUserSearchService userSearchService;

    // ========================================================================
    // CREATE
    // ========================================================================

    @JmsListener(destination = JmsConfiguration.QUEUE_USER_CREATED, containerFactory = InugamiActiveMqConfig.FACTORY)
    public void onUserCreated(final CreatedUserEvent event) {
        userSearchService.indexUser(event.getId());
    }

    // ========================================================================
    // UPDATE
    // ========================================================================

    // ========================================================================
    // DELETE
    // ========================================================================
    @JmsListener(destination = JmsConfiguration.QUEUE_USER_DELETED, containerFactory = InugamiActiveMqConfig.FACTORY)
    public void onUserCreated(final DeletedUserEvent event) {
        userSearchService.indexUser(event.getId());
    }
}
