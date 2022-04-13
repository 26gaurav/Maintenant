package com.project.maintenant.repo;

import com.project.maintenant.model.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {
    List<WorkerEntity> getByUsername(String username);
}
