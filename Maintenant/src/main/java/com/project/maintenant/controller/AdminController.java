package com.project.maintenant.controller;

import com.project.maintenant.model.entities.ComplaintEntity;
import com.project.maintenant.services.ComplaintEntityService;
import com.project.maintenant.services.UserEnitityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private UserEnitityService userEnitityService;

    @Autowired
    private ComplaintEntityService complaintEntityService;

    @PostMapping("/admin/login")
    public ResponseEntity<?> adminLogin(@RequestBody Map<String,Object> payload){
        if (userEnitityService.adminLogin(payload)){
            return ResponseEntity.ok("Admin logged in Successfully");
        }
        else
            return ResponseEntity.badRequest().body("Invalid Username or Password of admin!");
    }

    @RequestMapping(value="/admin/getAllComplaints")
    public ResponseEntity<?> getAllComplaints(){
        System.out.println("in get all complaints api");
        List<ComplaintEntity> complaints = complaintEntityService.getAllComplaints();
        return ResponseEntity.ok(complaints);
    }


}
