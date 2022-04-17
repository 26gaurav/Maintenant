package com.project.maintenant.services;

import com.project.maintenant.model.entities.ComplaintEntity;
import com.project.maintenant.model.entities.UserEntity;
import com.project.maintenant.repo.ComplaintRepository;
import com.project.maintenant.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ComplaintEntityService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    public String addComplaint(Map<String, Object> payload,Long userId){
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

            return "Complaint Added";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public List<ComplaintEntity> getAllComplaints(){
        List<ComplaintEntity> complaintEntityList = new ArrayList<ComplaintEntity>();
        complaintRepository.findAll().forEach(complaint ->complaintEntityList.add(complaint));
        return complaintEntityList;
    }

    public ComplaintEntity getComplaint(long complaintId){
        Optional<ComplaintEntity> complaint= this.complaintRepository.findById(complaintId);
        return complaint.get();
    }

    public String updateComplaint(Map<String, Object> payload,Long complaintId){
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

            return "Complaint Updated";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String deleteComplaint(Map<String, Object> payload,Long complaintId){
        try {
            System.out.println("In delete Complaint service");
            complaintRepository.deleteById(complaintId);
            return "Complaint Deleted";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
