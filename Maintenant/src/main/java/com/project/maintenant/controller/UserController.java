package com.project.maintenant.controller;

import com.project.maintenant.model.entities.ComplaintEntity;
import com.project.maintenant.model.entities.UserEntity;
import com.project.maintenant.services.ComplaintEntityService;
import com.project.maintenant.services.UserEnitityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserEnitityService userEnitityService;

    @Autowired
    private ComplaintEntityService complaintEntityService;

    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addPatient(@RequestBody Map<String,Object> payload) throws Exception{
        System.out.println("in add user api: REGISTER");
        UserEntity user = userEnitityService.addUser(payload);
        return  ResponseEntity.ok(user);
    }

    @RequestMapping(value= "/user/login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Map<String,Object> payload) throws Exception{

        UserEntity user= userEnitityService.loginUser(payload);
        if (user!=null){
            return ResponseEntity.ok(user);
        }
        else
            return ResponseEntity.badRequest().body("Invalid Username or Password!");
    }

    @RequestMapping("/getAllUsers")
    public ResponseEntity<?> getAllUser(){

        System.out.println("In get all user api");
        List<UserEntity> users = userEnitityService.getAllusers();
        return ResponseEntity.ok(users);
    }

    //find current user(given username return id)
    @RequestMapping("/getUserId/{username}")
    public ResponseEntity<?> getUserId(@PathVariable String username){

        System.out.println("In get user api");
        long id= userEnitityService.getUserId(username);
        return ResponseEntity.ok(new Long(id));
    }


    //User interaction with complaints
    @RequestMapping(value="/lodgeComplaint/{userId}", method = RequestMethod.POST)
    public ResponseEntity<?> lodgeComplaint(@RequestBody Map<String,Object> payload, @PathVariable Long userId) throws Exception{
        System.out.println("in lodge complaint api");
        ComplaintEntity complaint = complaintEntityService.addComplaint(payload,userId);
        return  ResponseEntity.ok(complaint);
    }

    @RequestMapping(value="/getComplaint/{complaintId}")
    public ResponseEntity<?> getComplaint(@PathVariable Long complaintId){
        System.out.println("in get complaint api");
        ComplaintEntity complaint = complaintEntityService.getComplaint(complaintId);
        return ResponseEntity.ok(complaint);
    }

    @RequestMapping(value="/updateComplaint/{complaintId}", method = RequestMethod.POST)
    public ResponseEntity<?> updateComplaint(@RequestBody Map<String,Object> payload, @PathVariable Long complaintId) throws Exception{
        System.out.println("in update complaint api");
        ComplaintEntity complaint = complaintEntityService.updateComplaint(payload,complaintId);
        return  ResponseEntity.ok(complaint);
    }

    @RequestMapping(value="/deleteComplaint/{complaintId}")
    public ResponseEntity<?> deleteComplaint(@PathVariable Long complaintId) throws Exception{
        System.out.println("in delete complaint api");
        ComplaintEntity complaint = complaintEntityService.deleteComplaint(complaintId);
        return  ResponseEntity.ok(complaint);
    }

    //this returns an array of Json Objects which is printed as table in client side
    @RequestMapping(value="/getAllComplaint/{userId}")
    public ResponseEntity<?> getAllComplaintsUser(@PathVariable Long userId){
        System.out.println("in get complaint api");
        List<ComplaintEntity> complaintEntityList = complaintEntityService.getAllComplaintsUser(userId);
        return ResponseEntity.ok(complaintEntityList);
    }
}

