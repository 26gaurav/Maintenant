package com.project.maintenant.repo;

import com.project.maintenant.model.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {
    List<WorkerEntity> getByUsername(String username);
}
