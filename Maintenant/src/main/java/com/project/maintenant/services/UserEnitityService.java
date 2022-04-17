package com.project.maintenant.services;

import com.project.maintenant.model.entities.UserEntity;
import com.project.maintenant.model.entities.WorkerEntity;
import com.project.maintenant.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

            user.setUsername((String) payload.get("username"));
            user.setPassword((String) payload.get("password"));

            System.out.println(user);
            System.out.println(user.getAddressDetail());
            System.out.println(user.getId());
            System.out.println("before save");
            UserEntity user1 = userRepository.save(user);
            //System.out.println(user1.getId());

            return "User Added";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public List<UserEntity> getAllusers(){
        List<UserEntity> users = new ArrayList<UserEntity>();
        userRepository.findAll().forEach(user ->users.add(user));
        return users;
    }

    public boolean login(Map<String, Object> payload){
        List<UserEntity> userEntityList = userRepository.getByUsername((String) payload.get("username"));
        if (userEntityList.size()>0 &&
                userEntityList.get(0).getPassword().equals((String) payload.get("password"))){
            return true;
        }
        return false;
    }

    public boolean adminLogin(Map<String, Object> payload){

        //hardcoded username and password of admin
        if(payload.get("username").equals("admin") && payload.get("password").equals("password")){
            return true;
        }else
            return false;
    }
}
