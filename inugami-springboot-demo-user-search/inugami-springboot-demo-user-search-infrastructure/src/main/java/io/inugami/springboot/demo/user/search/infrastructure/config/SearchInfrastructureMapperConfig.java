package io.inugami.springboot.demo.user.search.infrastructure.config;

import io.inugami.springboot.demo.user.search.infrastructure.mapper.UserDTOMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchInfrastructureMapperConfig {

    @Bean
    public UserDTOMapper userDTOMapper(){
        return Mappers.getMapper(UserDTOMapper.class);
    }
}
