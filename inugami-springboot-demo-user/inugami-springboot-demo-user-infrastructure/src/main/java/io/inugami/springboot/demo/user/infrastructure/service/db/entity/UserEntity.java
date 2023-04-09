package io.inugami.springboot.demo.user.infrastructure.service.db.entity;

import io.inugami.springboot.demo.user.api.time.ClockUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
@Table(name = "app_user")
@Entity
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -25165866842375401L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long          id;
    private String        firstname;
    private String        lastname;
    private String        email;
    private LocalDateTime createDate;
    private LocalDateTime modificationDate;

    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now(ClockUtil.getClock());
        modificationDate = LocalDateTime.now(ClockUtil.getClock());
    }

    @PreUpdate
    public void preUpdate() {
        modificationDate = LocalDateTime.now(ClockUtil.getClock());
    }
}
