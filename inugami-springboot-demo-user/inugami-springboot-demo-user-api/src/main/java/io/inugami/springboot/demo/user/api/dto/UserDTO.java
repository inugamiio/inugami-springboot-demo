package io.inugami.springboot.demo.user.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class UserDTO {
    private Long          id;
    private String        firstname;
    private String        lastname;
    private String        email;
    private LocalDateTime createDate;
    private LocalDateTime modificationDate;
}
