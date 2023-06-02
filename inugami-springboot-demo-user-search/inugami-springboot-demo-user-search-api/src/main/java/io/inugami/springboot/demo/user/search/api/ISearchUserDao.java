package io.inugami.springboot.demo.user.search.api;
import io.inugami.springboot.demo.user.search.api.dto.UserDTO;
public interface ISearchUserDao {

    UserDTO getUserById(final long id);
}
