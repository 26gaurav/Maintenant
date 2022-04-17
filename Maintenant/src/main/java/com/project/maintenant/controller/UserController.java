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
        String res = userEnitityService.addUser(payload);
        return  ResponseEntity.ok(res);
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody Map<String,Object> payload){
        if (userEnitityService.login(payload)){
            return ResponseEntity.ok("User logged in Successfully");
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

    //User interaction with complaints
    @RequestMapping(value="/lodgeComplaint/{userId}", method = RequestMethod.POST)
    public ResponseEntity<?> lodgeComplaint(@RequestBody Map<String,Object> payload, @PathVariable Long userId) throws Exception{
        System.out.println("in lodge complaint api");
        String res = complaintEntityService.addComplaint(payload,userId);
        return  ResponseEntity.ok(res);
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
        String res = complaintEntityService.updateComplaint(payload,complaintId);
        return  ResponseEntity.ok(res);
    }

    @RequestMapping(value="/deleteComplaint/{complaintId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteComplaint(@RequestBody Map<String,Object> payload, @PathVariable Long complaintId) throws Exception{
        System.out.println("in delete complaint api");
        String res = complaintEntityService.deleteComplaint(payload,complaintId);
        return  ResponseEntity.ok(res);
    }

}
