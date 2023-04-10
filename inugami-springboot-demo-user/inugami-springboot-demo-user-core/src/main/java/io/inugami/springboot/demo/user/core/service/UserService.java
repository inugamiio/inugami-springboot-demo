package io.inugami.springboot.demo.user.core.service;

import io.inugami.springboot.demo.user.api.dto.UserDTO;
import io.inugami.springboot.demo.user.api.exception.UserError;
import io.inugami.springboot.demo.user.api.service.IUserDAO;
import io.inugami.springboot.demo.user.api.service.IUserEventPublisher;
import io.inugami.springboot.demo.user.api.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static io.inugami.api.exceptions.Asserts.*;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final IUserDAO            userDAO;
    private final IUserEventPublisher userEventPublisher;

    // ========================================================================
    // CREATE
    // ========================================================================
    @Override
    public UserDTO createUser(final UserDTO user) {
        assertNotNull(UserError.USER_DATA_REQUIRED, user);
        assertModel(
                () -> assertNotEmpty(UserError.USER_DATA_REQUIRED, user.getLastname()),
                () -> assertNotEmpty(UserError.USER_USER_FIRSTNAME_REQUIRED, user.getFirstname()),
                () -> assertNotEmpty(UserError.USER_USER_EMAIL_REQUIRED, user.getEmail())
        );

        final Optional<UserDTO> existingUser = userDAO.getUserByEmail(user.getEmail());
        assertFalse(UserError.USER_ALREADY_EXISTS, existingUser.isPresent());

        final UserDTO newUser = userDAO.createUser(user);
        assertNotNull(UserError.USER_CAN_NOT_BE_CREATED, newUser);

        userEventPublisher.sendCreatedUser(newUser);
        return newUser;
    }

    // ========================================================================
    // READ
    // ========================================================================
    @Override
    public UserDTO getUserByID(final long id) {
        assertHigher(UserError.USER_INVALID_ID, 0, id);
        final UserDTO user = userDAO.getUserByID(id);
        return user;
    }

    // ========================================================================
    // UPDATE
    // ========================================================================

    // ========================================================================
    // DELETE
    // ========================================================================
}
