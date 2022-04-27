package com.project.maintenant.controller;

import com.project.maintenant.model.entities.ComplaintEntity;
import com.project.maintenant.model.entities.Response;
import com.project.maintenant.model.entities.WorkerEntity;
import com.project.maintenant.services.ComplaintEntityService;
import com.project.maintenant.services.UserEnitityService;
import com.project.maintenant.services.WorkerEntityService;
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

    @Autowired
    private WorkerEntityService workerEntityService;

    @PostMapping("/admin/login")
    public ResponseEntity<?> adminLogin(@RequestBody Map<String,Object> payload){
        if (userEnitityService.adminLogin(payload)){
            return ResponseEntity.ok(payload);
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

    @PostMapping("/admin/addWorker")
    public ResponseEntity<?> addWorker(@RequestBody Map<String,Object> payload){
        WorkerEntity workerEntity = workerEntityService.addWorker(payload);
        if (workerEntity!=null){
            return ResponseEntity.ok(workerEntity);
        }
        else
            return ResponseEntity.badRequest().body("worker's Username already exists");
    }

    @GetMapping("/admin/getAllWorkers")
    public ResponseEntity<?> getAllWorkers(){

        System.out.println("in get all workers api");
        List<WorkerEntity> workerEntityList = workerEntityService.getAllWorkers();
        return ResponseEntity.ok(workerEntityList);
    }

    @GetMapping("/admin/{worker_id}/deleteWorker")
    public ResponseEntity<?> deleteWorker(@PathVariable Long worker_id) throws Exception{

        System.out.println("In delete worker api");
        if (workerEntityService.deleteWorker(worker_id))
            return ResponseEntity.ok(new Response("Successfully deleted"));
        else
            return ResponseEntity.ok(new Response("Worker has Pending Works."));
    }

    @GetMapping("/admin/{complaint_id}/updateProgress")
    public ResponseEntity<?> updateProgress(@PathVariable Long complaint_id){
        workerEntityService.updateProgress((long)-1, complaint_id);
        return ResponseEntity.ok(new Response("Complaint updated successfully"));
    }

    @GetMapping("/admin/{worker_id}/{complaint_id}/complaintMapping")
    public ResponseEntity<?> complaintMapping(@PathVariable  Long worker_id, @PathVariable Long complaint_id){
        if(complaintEntityService.complaintMapping(worker_id, complaint_id)){
            return ResponseEntity.ok(new Response("Worker mapped successfully"));
        }
        else
            return ResponseEntity.badRequest().body(new Response("Worker already mapped to the given complaint"));
    }
}
