package io.inugami.springboot.demo.user.interfaces.rest;

import io.inugami.springboot.demo.user.api.dto.UserDTO;
import io.inugami.springboot.demo.user.api.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = {"user"})
@RequiredArgsConstructor
@RestController
public class UserRestController {
    private final IUserService userService;


    // ========================================================================
    // CREATE
    // ========================================================================
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO createUser(@RequestBody final UserDTO user) {
        return userService.createUser(user);
    }

    // ========================================================================
    // READ
    // ========================================================================
    @GetMapping(path = "{id}")
    public UserDTO getUserById(@PathVariable final long id) {
        return userService.getUserByID(id);
    }
    // ========================================================================
    // UPDATE
    // ========================================================================

    // ========================================================================
    // DELETE
    // ========================================================================
    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable final long id, @RequestParam String email) {
        userService.deleteByID(id, email);
    }
}
