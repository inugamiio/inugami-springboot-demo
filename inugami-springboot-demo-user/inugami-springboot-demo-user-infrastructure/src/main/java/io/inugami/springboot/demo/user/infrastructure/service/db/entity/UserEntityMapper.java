package io.inugami.springboot.demo.user.infrastructure.service.db.entity;


import io.inugami.springboot.demo.user.api.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserEntityMapper {

    UserDTO convert(final UserEntity entity);


    UserEntity convert(final UserDTO entity);
}
