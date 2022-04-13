package com.project.maintenant.services;

import com.project.maintenant.model.entities.WorkerEntity;
import com.project.maintenant.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class WorkerEntityService {

    @Autowired
    WorkerRepository workerRepository;

    public boolean login(Map<String, Object> payload){
        List<WorkerEntity> workerEntityList = workerRepository.getByUsername((String) payload.get("username"));
        if (workerEntityList.size()>0 &&
                workerEntityList.get(0).getPassword().equals((String) payload.get("password"))){
            return true;
        }
        return false;
    }
}
