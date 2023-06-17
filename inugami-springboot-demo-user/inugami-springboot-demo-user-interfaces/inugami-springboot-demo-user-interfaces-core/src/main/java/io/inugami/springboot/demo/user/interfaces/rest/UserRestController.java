package io.inugami.springboot.demo.user.interfaces.rest;

import io.inugami.springboot.demo.user.api.dto.UserDTO;
import io.inugami.springboot.demo.user.api.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class UserRestController implements UserRestClient {
    private final IUserService userService;


    // ========================================================================
    // CREATE
    // ========================================================================
    public UserDTO createUser(final UserDTO user) {
        return userService.createUser(user);
    }

    // ========================================================================
    // READ
    // ========================================================================
    public UserDTO getUserById(final long id) {
        return userService.getUserByID(id);
    }


    // ========================================================================
    // UPDATE
    // ========================================================================
    @Override
    public UserDTO updateUser(final UserDTO user) {
        return null;
    }
    // ========================================================================
    // DELETE
    // ========================================================================
    public void deleteById(final long id, String email) {
        userService.deleteByID(id, email);
    }
}
