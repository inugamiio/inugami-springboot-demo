package io.inugami.springboot.demo.user.search.api;

import io.inugami.springboot.demo.user.search.api.dto.UserDTO;

public interface IUserSearchService {
    void indexUser(long userId);
}
