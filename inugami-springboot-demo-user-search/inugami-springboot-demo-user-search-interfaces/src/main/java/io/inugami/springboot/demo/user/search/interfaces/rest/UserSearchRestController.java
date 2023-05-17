package io.inugami.springboot.demo.user.search.interfaces.rest;

import io.inugami.springboot.demo.user.search.api.IUserSearchService;
import io.inugami.springboot.demo.user.search.api.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "search/user")
@RequiredArgsConstructor
@RestController
public class UserSearchRestController {
    private final IUserSearchService userSearchService;

    @GetMapping(path = "index/{id}")
    public void indexById(@PathVariable final long id) {
        userSearchService.indexUser(id);
    }
}
