package com.project.maintenant.controller;

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

    @RequestMapping("/getAllUsers")
    public ResponseEntity<?> getAllUser(){

        System.out.println("In get all user api");
        List<UserEntity> patients = userEnitityService.getAllusers();
        return ResponseEntity.ok(patients);
    }

    @RequestMapping(value="/lodgeComplaint", method = RequestMethod.POST)
    public ResponseEntity<?> lodgeComplaint(@RequestBody Map<String,Object> payload) throws Exception{
        System.out.println("in lodge complaint api");
        String res = complaintEntityService.addComplaint(payload);
        return  ResponseEntity.ok(res);
    }
}
