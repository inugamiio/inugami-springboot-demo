package io.inugami.springboot.demo.user.search.infrastructure;

import io.inugami.springboot.demo.user.interfaces.rest.UserRestClient;
import io.inugami.springboot.demo.user.search.api.ISearchUserDao;
import io.inugami.springboot.demo.user.search.api.dto.UserDTO;
import io.inugami.springboot.demo.user.search.infrastructure.mapper.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserDao implements ISearchUserDao {

    private final UserRestClient userRestClient;
    private final UserDTOMapper  userDTOMapper;

    @Override
    public UserDTO getUserById(final long id) {
        return userDTOMapper.convertToUserDTO(userRestClient.getUserById(id));
    }
}
