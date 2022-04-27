package com.project.maintenant.services;

import com.project.maintenant.model.entities.UserEntity;
import com.project.maintenant.model.entities.WorkerEntity;
import com.project.maintenant.model.entities.ComplaintEntity;
import com.project.maintenant.repo.WorkerRepository;
import com.project.maintenant.repo.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkerEntityService {

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    ComplaintRepository complaintRepository;

    public WorkerEntity login(Map<String, Object> payload){
        List<WorkerEntity> workerEntityList = workerRepository.getByUsername((String) payload.get("username"));
        if (workerEntityList.size()>0 &&
                workerEntityList.get(0).getPassword().equals((String) payload.get("password"))){
            return workerEntityList.get(0);
        }
        return null;
    }

    public List<ComplaintEntity> assignedComplaints(Long id){
        WorkerEntity workerEntity = workerRepository.getById(id);
        List<ComplaintEntity> complaintEntityList = complaintRepository.getComplaintEntityByAssignedWorker(workerEntity);
//        if (complaintEntityList.size()==0)
//            return null;
        return complaintEntityList;
    }

    public boolean updateProgress(Long worker_id, Long complaintId){
        ComplaintEntity complaintEntity = complaintRepository.getById(complaintId);
        if(worker_id==-1)//means admin initiated the progress
        {
            System.out.println("Admin init");
            complaintEntity.setProgressLevel(3);
            complaintRepository.save(complaintEntity);
            return true;
        }
        WorkerEntity workerEntity = workerRepository.getById(worker_id);
        for(WorkerEntity w : complaintEntity.getAssignedWorker()){
            if(w.getId()==workerEntity.getId()){
                complaintEntity.setProgressLevel(2);
                complaintRepository.save(complaintEntity);
                return true;
            }
        }
        return false;
    }


    //ADMIN PART OF WORKER

    public WorkerEntity addWorker(Map<String, Object> payload){
        System.out.println("In add User service");
        List<WorkerEntity> workerEntityList = workerRepository.findAll();
        for(WorkerEntity w:workerEntityList){
            if(w.getUsername().equals((String) payload.get("username")))
                return null;
        }

        WorkerEntity worker = new WorkerEntity();

        String address = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
        address = address + "\"addLine2\": \"" + (String) payload.get("addLine2") + "\" ,";
        address = address + "\"district\": \"" + (String) payload.get("district") + "\" ,";
        address = address + "\"state\": \"" + (String) payload.get("state") + "\" ,";
        address = address + "\"pin\": \"" + (String) payload.get("pin") + "\" }";

        worker.setAddressDetail(address);
        worker.setAge((Integer) payload.get("age")) ;
        worker.setEmail((String) payload.get("email"));
        worker.setFirstName((String) payload.get("fname"));
        worker.setLastName((String) payload.get("lname"));
        worker.setGender((String)payload.get("gender"));
        worker.setPhoneNumber((String) payload.get("phone"));
        worker.setUsername((String) payload.get("username"));
        worker.setPassword((String) payload.get("password"));
        worker.setOrganisation((String) payload.get("organisation"));

        System.out.println(worker);
        System.out.println(worker.getAddressDetail());
        System.out.println(worker.getId());
        System.out.println("before save");
        WorkerEntity workerEntity = workerRepository.save(worker);

        return workerEntity;
    }

    public Boolean deleteWorker(Long id){
        WorkerEntity workerEntity = workerRepository.getById(id);
        List<ComplaintEntity> complaintEntityList = workerEntity.getComplaintEntity();
        for(ComplaintEntity c: complaintEntityList){
            if(c.getProgressLevel()!=3) //3 means task is not completed yet
            {
                return false;
            }
            complaintRepository.delete(c);
        }
        System.out.println("ready to delete a worker");
        workerRepository.delete(workerEntity);
        return true;
    }

    public List<WorkerEntity> getAllWorkers(){

        List<WorkerEntity> workerEntityList = workerRepository.findAll();
        return  workerEntityList;
    }
}
