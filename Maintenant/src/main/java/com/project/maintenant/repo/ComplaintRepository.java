package com.project.maintenant.repo;

import com.project.maintenant.model.entities.ComplaintEntity;
import com.project.maintenant.model.entities.UserEntity;
import com.project.maintenant.model.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Long> {

    List<ComplaintEntity> getComplaintEntityByAssignedWorker(WorkerEntity workerEntity);

    List<ComplaintEntity> getComplaintEntitiesByUserByCreatedBy(UserEntity userEntity);

}
