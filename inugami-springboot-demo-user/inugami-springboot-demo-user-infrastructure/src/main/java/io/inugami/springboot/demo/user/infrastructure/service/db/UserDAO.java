package io.inugami.springboot.demo.user.infrastructure.service.db;

import io.inugami.api.exceptions.Asserts;
import io.inugami.api.exceptions.UncheckedException;
import io.inugami.springboot.demo.user.api.dto.UserDTO;
import io.inugami.springboot.demo.user.api.exception.UserError;
import io.inugami.springboot.demo.user.api.service.IUserDAO;
import io.inugami.springboot.demo.user.infrastructure.service.db.entity.UserEntity;
import io.inugami.springboot.demo.user.infrastructure.service.db.entity.UserEntityMapper;
import io.inugami.springboot.demo.user.infrastructure.service.db.entity.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.Option;
import java.util.Optional;

import static io.inugami.api.exceptions.Asserts.*;

@RequiredArgsConstructor
@Service
public class UserDAO implements IUserDAO {

    // ========================================================================
    // REPOSITORY
    // ========================================================================
    private final UserEntityRepository repository;
    private final UserEntityMapper     mapper;

    // ========================================================================
    // CREATE
    // ========================================================================
    @Transactional
    @Override
    public UserDTO createUser(final UserDTO user) {
        assertNotNull(UserError.USER_DATA_REQUIRED, user);
        try {
            final UserEntity entity      = mapper.convert(user);
            final UserEntity savedEntity = repository.save(entity);
            return mapper.convert(savedEntity);
        } catch (Throwable e) {
            throw new UncheckedException(UserError.USER_CAN_NOT_BE_CREATED.addDetail(e.getMessage()), e);
        }
    }

    // ========================================================================
    // READ
    // ========================================================================
    @Override
    public UserDTO getUserByID(final long id) {
        Optional<UserEntity> user = null;

        try {
            user = repository.findById(id);
        } catch (Throwable e) {
            throw new UncheckedException(UserError.USER_CAN_NOT_READ_DATA.addDetail(e.getMessage()), e);
        }
        assertNotNull(UserError.USER_NOT_FOUND, user);
        assertTrue(UserError.USER_NOT_FOUND, user.isPresent());
        return mapper.convert(user.get());
    }

    @Override
    public Optional<UserDTO> getUserByEmail(final String email) {
        assertNotEmpty(UserError.USER_GET_EMAIL_REQUIRED, email);
        Optional<UserEntity> user = Optional.empty();

        try {
            user = repository.findByEmail(email);
        } catch (Throwable e) {
            throw new UncheckedException(UserError.USER_CAN_NOT_READ_DATA.addDetail(e.getMessage()), e);
        }

        return user.isPresent() ? Optional.of(mapper.convert(user.get())) : Optional.empty();
    }
    // ========================================================================
    // UPDATE
    // ========================================================================

    // ========================================================================
    // DELETE
    // ========================================================================


}
