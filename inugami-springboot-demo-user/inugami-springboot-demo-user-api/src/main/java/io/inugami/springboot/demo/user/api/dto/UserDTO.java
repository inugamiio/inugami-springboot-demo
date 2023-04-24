package io.inugami.springboot.demo.user.api.dto;

import io.inugami.api.documentation.Glossary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Glossary("utilisateur")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class UserDTO {
    private Long          id;
    @Glossary("prénom")
    private String        firstname;
    @Glossary("nom")
    private String        lastname;
    private String        email;
    private LocalDateTime createDate;
    private LocalDateTime modificationDate;
}
