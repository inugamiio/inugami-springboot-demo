package io.inugami.springboot.demo.user.search.infrastructure.mapper;

import io.inugami.springboot.demo.user.search.api.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserDTOMapper {

    UserDTO convertToUserDTO(io.inugami.springboot.demo.user.api.dto.UserDTO dto);
}
