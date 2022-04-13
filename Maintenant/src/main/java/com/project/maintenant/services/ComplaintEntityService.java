package com.project.maintenant.services;

import com.project.maintenant.model.entities.ComplaintEntity;
import com.project.maintenant.model.entities.UserEntity;
import com.project.maintenant.repo.ComplaintRepository;
import com.project.maintenant.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ComplaintEntityService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public String addComplaint(Map<String, Object> payload){
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
            ComplaintEntity complaint1 = complaintRepository.save(complaint);
            //System.out.println(user1.getId());

            return "Complaint Added";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
