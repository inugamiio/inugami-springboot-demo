package io.inugami.springboot.demo.user.api.dto;

import io.inugami.api.documentation.Glossaries;
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
    @Glossaries({
            @Glossary(value = "prénom", language = "fr", description = "Le prénom de l'utilisateur"),
            @Glossary(value = "firstname", language = "en", description = "User's firstname")
    }
    )
    private String        firstname;
    @Glossary("nom")
    private String        lastname;
    private String        email;
    private LocalDateTime createDate;
    private LocalDateTime modificationDate;
}
