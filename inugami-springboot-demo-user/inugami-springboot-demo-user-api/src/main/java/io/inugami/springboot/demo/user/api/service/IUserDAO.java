package io.inugami.springboot.demo.user.api.service;

import io.inugami.springboot.demo.user.api.dto.UserDTO;

import java.util.Optional;

public interface IUserDAO {
    // ========================================================================
    // CREATE
    // ========================================================================
    UserDTO createUser(final UserDTO user);

    // ========================================================================
    // READ
    // ========================================================================
    UserDTO getUserByID(final long id);

    Optional<UserDTO> getUserByEmail(final String email);

    // ========================================================================
    // UPDATE
    // ========================================================================

    // ========================================================================
    // DELETE
    // ========================================================================
     void deleteByID(final long id);
}
