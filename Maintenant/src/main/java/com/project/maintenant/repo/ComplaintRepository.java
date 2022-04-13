package com.project.maintenant.repo;

import com.project.maintenant.model.entities.ComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Long> {
}
