package com.project.maintenant.controller;

import com.project.maintenant.services.UserEnitityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserEnitityService userEnitityService;

    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addPatient(@RequestBody Map<String,Object> payload) throws Exception{
        System.out.println("in add user api: REGISTER");
        String res = userEnitityService.addUser(payload);
        return  ResponseEntity.ok(res);
    }
}
