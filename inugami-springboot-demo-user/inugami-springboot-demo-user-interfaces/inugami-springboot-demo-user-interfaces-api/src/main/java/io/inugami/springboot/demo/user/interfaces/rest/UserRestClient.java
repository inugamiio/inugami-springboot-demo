package io.inugami.springboot.demo.user.interfaces.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.inugami.springboot.demo.user.api.dto.UserDTO;
@RequestMapping(path = "user")
public interface UserRestClient {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO createUser(@RequestBody final UserDTO user) ;

    @GetMapping(path = "{id}")
    UserDTO getUserById(@PathVariable final long id);

    @PatchMapping(path = "{id}")
    UserDTO updateUser(@RequestBody final UserDTO user);

    @DeleteMapping(path = "{id}")
    void deleteById(@PathVariable final long id, @RequestParam String email) ;
}
