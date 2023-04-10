package io.inugami.springboot.demo.user.search.core;

import io.inugami.api.exceptions.Asserts;
import io.inugami.springboot.demo.user.search.api.IUserSearchService;
import io.inugami.springboot.demo.user.search.api.exception.UserSearchError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static io.inugami.api.exceptions.asserts.AssertHigher.assertHigher;
import static io.inugami.springboot.demo.user.search.api.exception.UserSearchError.USER_SEARCH_INVALID_ID;

@Slf4j
@Service
public class UserSearchService implements IUserSearchService {


    @Override
    public void indexUser(final long userId) {
        assertHigher(USER_SEARCH_INVALID_ID, 0, userId);
        log.info("begin indexing user : {}", userId);
    }
}
