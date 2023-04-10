package io.inugami.springboot.demo.user.infrastructure.service.db.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findById(final long id);
    Optional<UserEntity> findByEmail(final String email);

}
