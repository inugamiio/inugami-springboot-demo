package io.inugami.springboot.demo.user.core.service;

import io.inugami.commons.test.UnitTestHelper;
import io.inugami.springboot.demo.user.api.dto.UserDTO;
import io.inugami.springboot.demo.user.api.exception.UserError;
import io.inugami.springboot.demo.user.api.service.IUserDAO;
import io.inugami.springboot.demo.user.api.service.IUserEventPublisher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static io.inugami.commons.test.UnitTestHelper.assertText;
import static io.inugami.commons.test.UnitTestHelper.assertThrows;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private IUserDAO userDAO;

    @Mock
    private IUserEventPublisher userEventPublisher;

    @Captor
    private ArgumentCaptor<UserDTO> userCaptor;

    @InjectMocks
    private UserService userService;

    @Test
    public void createUser_withoutValue_shouldThrow() {
        assertThrows(UserError.USER_DATA_REQUIRED, () -> userService.createUser(null));
    }

    @Test
    public void createUser_withoutLastname_shouldThrow() {
        final UserDTO.UserDTOBuilder user = buildUser().toBuilder();
        assertThrows(UserError.USER_DATA_REQUIRED, () -> userService.createUser(user.lastname(null).build()));
        assertThrows(UserError.USER_DATA_REQUIRED, () -> userService.createUser(user.lastname("").build()));
    }

    @Test
    public void createUser_withoutFirstname_shouldThrow() {
        final UserDTO.UserDTOBuilder user = buildUser().toBuilder();
        assertThrows(UserError.USER_USER_FIRSTNAME_REQUIRED, () -> userService.createUser(user.firstname(null).build()));
        assertThrows(UserError.USER_USER_FIRSTNAME_REQUIRED, () -> userService.createUser(user.firstname("").build()));
    }

    @Test
    public void createUser_withoutEmail_shouldThrow() {
        final UserDTO.UserDTOBuilder user = buildUser().toBuilder();
        assertThrows(UserError.USER_USER_EMAIL_REQUIRED, () -> userService.createUser(user.email(null).build()));
        assertThrows(UserError.USER_USER_EMAIL_REQUIRED, () -> userService.createUser(user.email("").build()));
    }


    @Test
    public void createUser_withSavingError_shouldThrow() {
        final UserDTO.UserDTOBuilder user = buildUser().toBuilder();
        assertThrows(UserError.USER_CAN_NOT_BE_CREATED, () -> userService.createUser(user.build()));
    }

    @Test
    public void createUser_withUserAlreadyExists_shouldThrow() {
        final UserDTO.UserDTOBuilder user = buildUser().toBuilder();
        when(userDAO.getUserByEmail(anyString())).thenReturn(Optional.of(UserDTO.builder().build()));
        assertThrows(UserError.USER_ALREADY_EXISTS, () -> userService.createUser(user.build()));
    }

    @Test
    public void createUser_nominal() {
        final UserDTO user = buildUser();
        when(userDAO.createUser(any())).thenAnswer(answer -> ((UserDTO) answer.getArgument(0)).toBuilder().id(1L).build());

        assertThat(userService.createUser(user).getId()).isEqualTo(1L);
        verify(userEventPublisher).sendCreatedUser(userCaptor.capture());

        assertText(userCaptor.getValue(), """
                {
                  "email" : "john.smith@inugami.io",
                  "firstname" : "John",
                  "id" : 1,
                  "lastname" : "Smith"
                }
                """);
    }

    // ========================================================================
    // TOOLS
    // ========================================================================
    private UserDTO buildUser() {
        return UserDTO.builder()
                      .id(1L)
                      .firstname("John")
                      .lastname("Smith")
                      .email("john.smith@inugami.io")
                      .build();
    }
}