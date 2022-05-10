package com.project.maintenant.controller;

import com.project.maintenant.model.ComplaintEntity;
import com.project.maintenant.model.Response;
import com.project.maintenant.services.WorkerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class WorkerController {

    @Autowired
    WorkerEntityService workerEntityService;

    @PostMapping("/worker/login")
    public ResponseEntity<?> login(@RequestBody Map<String,Object> payload){
        if (workerEntityService.login(payload)!=null){
            return ResponseEntity.ok(workerEntityService.login(payload));
        }
        else
            return ResponseEntity.badRequest().body(new Response("Invalid Username and Password"));
    }

    @GetMapping("worker/{id}/assignedComplaint")
    public ResponseEntity<?> getAssignedComplaint(@PathVariable Long id){
        List<ComplaintEntity> complaintEntity = workerEntityService.assignedComplaints(id);
        if (complaintEntity.size()==0)
            return ResponseEntity.badRequest().body("No complaint Assigned to the worker");
        else
            return ResponseEntity.ok(complaintEntity);
    }

    @GetMapping("worker/{worker_id}/{complaint_id}/updateProgress")
    public ResponseEntity<?> updateProgress(@PathVariable Long worker_id, @PathVariable Long complaint_id){
        if(workerEntityService.updateProgress(worker_id, complaint_id))
            return ResponseEntity.ok(new Response("Progress updated successfully"));
        else
            return ResponseEntity.badRequest().body(new Response("progress update failed;"));
    }
}
