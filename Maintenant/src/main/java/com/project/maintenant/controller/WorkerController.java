package com.project.maintenant.controller;

import com.project.maintenant.services.WorkerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class WorkerController {
    @Autowired
    WorkerEntityService workerEntityService;

    @PostMapping("/worker/login")
    public ResponseEntity<?> login(@RequestBody Map<String,Object> payload){
        if (workerEntityService.login(payload)){
            return ResponseEntity.ok("User logged in Successfully");
        }
        else
            return ResponseEntity.badRequest().body("Invalid Username or Password!");
    }
}
