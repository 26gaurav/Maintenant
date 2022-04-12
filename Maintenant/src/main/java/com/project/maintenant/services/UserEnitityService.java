package com.project.maintenant.services;

import com.project.maintenant.model.entities.UserEntity;
import com.project.maintenant.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

@Service
public class UserEnitityService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(Map<String, Object> payload){
        try {
            System.out.println("In add User service");
            UserEntity user = new UserEntity();


            String address = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
            address = address + "\"addLine2\": \"" + (String) payload.get("addLine2") + "\" ,";
            address = address + "\"district\": \"" + (String) payload.get("district") + "\" ,";
            address = address + "\"state\": \"" + (String) payload.get("state") + "\" ,";
            address = address + "\"pin\": \"" + (String) payload.get("pin") + "\" }";
            user.setAddressDetail(address);
            user.setAge((Integer) payload.get("age")) ;


            user.setEmail((String) payload.get("email"));
            user.setFirstName((String) payload.get("fname"));
            user.setLastName((String) payload.get("lname"));
            user.setGender((String)payload.get("gender"));


            user.setPhoneNumber((String) payload.get("phone"));
            System.out.println("before save");
            UserEntity user1 = userRepository.save(user);
            //System.out.println(user1.getId());

            return "User Added";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }


}
