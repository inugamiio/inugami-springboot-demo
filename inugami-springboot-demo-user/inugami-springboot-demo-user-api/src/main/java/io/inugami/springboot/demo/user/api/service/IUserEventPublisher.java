package io.inugami.springboot.demo.user.api.service;

import io.inugami.springboot.demo.user.api.dto.UserDTO;

public interface IUserEventPublisher {
    // ========================================================================
    // CREATE
    // ========================================================================
    void sendCreatedUser(final UserDTO user);


    // ========================================================================
    // UPDATE
    // ========================================================================
    void sendUpdatedUser(final UserDTO user);

    // ========================================================================
    // DELETE
    // ========================================================================
    void sendDeletedUser(final UserDTO user);
}
