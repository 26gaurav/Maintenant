package com.project.maintenant.repo;

import com.project.maintenant.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> getByUsername(String username);
}
