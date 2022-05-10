package com.project.maintenant.services;

import com.project.maintenant.model.entities.ComplaintEntity;
import com.project.maintenant.model.entities.UserEntity;
import com.project.maintenant.model.entities.WorkerEntity;
import com.project.maintenant.repo.ComplaintRepository;
import com.project.maintenant.repo.UserRepository;
import com.project.maintenant.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ComplaintEntityService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkerRepository workerRepository;

    public ComplaintEntity addComplaint(Map<String, Object> payload,Long userId){
        try {
            System.out.println("In add Complaint service");
            ComplaintEntity complaint = new ComplaintEntity();

            complaint.setHeading((String) payload.get("heading"));
            complaint.setDescription((String) payload.get("description"));


            String address = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
            address = address + "\"addLine2\": \"" + (String) payload.get("addLine2") + "\" ,";
            address = address + "\"district\": \"" + (String) payload.get("district") + "\" ,";
            address = address + "\"state\": \"" + (String) payload.get("state") + "\" ,";
            address = address + "\"pin\": \"" + (String) payload.get("pin") + "\" }";
            complaint.setAddressDetail(address);

            complaint.setProgressLevel((Integer) payload.get("progressLevel"));
            complaint.setProgressDescription((String) payload.get("progressDescription"));

            System.out.println("before save");

            Optional<UserEntity> user= this.userRepository.findById(userId);
            complaint.setUserByCreatedBy(user.get());


            ComplaintEntity complaint1 = complaintRepository.save(complaint);

            return complaint1;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ComplaintEntity> getAllComplaints(){

        List<ComplaintEntity> complaintEntityList= complaintRepository.findAll();
//        List<ComplaintEntity> complaintEntityList = new ArrayList<ComplaintEntity>();
//        complaintRepository.findAll().forEach(complaint ->complaintEntityList.add(complaint));
        return complaintEntityList;
    }

    public ComplaintEntity getComplaint(long complaintId){
        Optional<ComplaintEntity> complaint= this.complaintRepository.findById(complaintId);
        return complaint.get();
    }

    public ComplaintEntity updateComplaint(Map<String, Object> payload,Long complaintId){
        try {
            System.out.println("In update Complaint service");
            Optional<ComplaintEntity> complaint= this.complaintRepository.findById(complaintId);


            complaint.get().setHeading((String) payload.get("heading"));
            complaint.get().setDescription((String) payload.get("description"));

            Date date= new Date();
            complaint.get().setIssueDate(new Timestamp(date.getTime()));


            String address = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
            address = address + "\"addLine2\": \"" + (String) payload.get("addLine2") + "\" ,";
            address = address + "\"district\": \"" + (String) payload.get("district") + "\" ,";
            address = address + "\"state\": \"" + (String) payload.get("state") + "\" ,";
            address = address + "\"pin\": \"" + (String) payload.get("pin") + "\" }";
            complaint.get().setAddressDetail(address);

            complaint.get().setProgressLevel((Integer) payload.get("progressLevel"));
            complaint.get().setProgressDescription((String) payload.get("progressDescription"));

            System.out.println("before save");

            ComplaintEntity complaint1 = complaintRepository.save(complaint.get());

            return complaint1;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ComplaintEntity deleteComplaint(Long complaintId){

        try {
            System.out.println("In delete Complaint service");
            ComplaintEntity complaintEntity = complaintRepository.getById(complaintId);

            //invoke copy constructor
            ComplaintEntity complaint1 = new ComplaintEntity(complaintEntity);
            complaintRepository.deleteById(complaintId);
            return complaint1;
        }catch (Exception e){
            return null;
        }
    }

    //FOR ADMIN operations
    public boolean complaintMapping(Long workerId, Long complaint_id){
        ComplaintEntity complaintEntity = complaintRepository.getById(complaint_id);
        System.out.println("here in cmplaintmaping of complaintEntityService");
        System.out.println(complaintEntity);
        List<WorkerEntity> workerEntityList = complaintEntity.getAssignedWorker();
        for(WorkerEntity worker: workerEntityList){
            System.out.println("in for each loop");
            System.out.println(worker.getId());
            if (worker.getId()==workerId)
                return false;
        }
        System.out.println("complaint_id is "+complaint_id+" worker_id "+workerId);
        WorkerEntity worker = workerRepository.getById(workerId);
        System.out.println("after for each loop "+worker.getId());
        workerEntityList.add(worker);
        complaintRepository.save(complaintEntity);
        return true;
    }

    public List<ComplaintEntity> getAllComplaintsUser(long userId){

        UserEntity user= userRepository.getById(userId);
        List<ComplaintEntity> complaintEntityList = complaintRepository.getComplaintEntitiesByUserByCreatedBy(user);

        return  complaintEntityList;
    }

}
