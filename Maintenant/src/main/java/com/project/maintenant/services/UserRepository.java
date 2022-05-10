package com.project.maintenant.services;

import com.project.maintenant.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> getByUsername(String username);
}
