package io.inugami.springboot.demo.user.infrastructure.service.db;

import io.inugami.springboot.demo.user.api.dto.UserDTO;
import io.inugami.springboot.demo.user.api.service.IUserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserDAO implements IUserDAO {


    @Override
    public UserDTO createUser(final UserDTO user) {
        return null;
    }

    @Override
    public UserDTO getUserByID(final long id) {
        return null;
    }
}
