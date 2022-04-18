package com.project.maintenant.repo;

import com.project.maintenant.model.entities.ComplaintEntity;
import com.project.maintenant.model.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Long> {

    List<ComplaintEntity> getComplaintEntityByAssignedWorker(WorkerEntity workerEntity);
}
