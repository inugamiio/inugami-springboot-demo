package io.inugami.springboot.demo.user.search.core;

import io.inugami.api.exceptions.Asserts;
import io.inugami.springboot.demo.user.search.api.ISearchUserDao;
import io.inugami.springboot.demo.user.search.api.IUserSearchService;
import io.inugami.springboot.demo.user.search.api.dto.UserDTO;
import io.inugami.springboot.demo.user.search.api.exception.UserSearchError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static io.inugami.api.exceptions.asserts.AssertHigher.assertHigher;
import static io.inugami.springboot.demo.user.search.api.exception.UserSearchError.USER_SEARCH_INVALID_ID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserSearchService implements IUserSearchService {

    private final ISearchUserDao searchUserDao;

    @Override
    public void indexUser(final long userId) {
        assertHigher(USER_SEARCH_INVALID_ID, 0, userId);
        log.info("begin indexing user : {}", userId);
        final UserDTO user = searchUserDao.getUserById(userId);
        log.info("user : {}", user);
    }
}
