package com.project.maintenant.repo;

import com.project.maintenant.model.ComplaintEntity;
import com.project.maintenant.model.UserEntity;
import com.project.maintenant.model.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Long> {

    List<ComplaintEntity> getComplaintEntityByAssignedWorker(WorkerEntity workerEntity);

    List<ComplaintEntity> getComplaintEntitiesByUserByCreatedBy(UserEntity userEntity);

}
