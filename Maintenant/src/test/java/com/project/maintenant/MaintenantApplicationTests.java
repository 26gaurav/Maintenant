// package com.project.maintenant;
//
// import com.project.maintenant.model.AdminEntity;
// import com.project.maintenant.model.UserEntity;
// import com.project.maintenant.services.UserEnitityService;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import lombok.extern.slf4j.Slf4j;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.junit.jupiter.api.Test;
//
// import java.util.HashMap;
// import static org.junit.jupiter.api.Assertions.*;
// import java.util.List;
// import java.util.Map;
//
// @SpringBootTest
// @Slf4j
// class MaintenantApplicationTests {
//
//     private static final Logger logger = LoggerFactory.getLogger(MaintenantApplicationTests.class);
//
//     @Autowired
//     private UserEnitityService userEnitityService;
//     @Test
//     void contextLoads() {
//     }
//
//     @Test
//     public void positiveTestPrimaryUserAuthentication()
//     {
//         logger.info("[INFO]: inside positiveTestPrimaryUserAuthentication()");
////         Map userdetails = new UserEntity();
////         userdetails.setUsername("admin");
//         HashMap<String, Object> userdetails = new HashMap<>();
//         userdetails.put("username", "admin");
//         userdetails.put("password", "password");
//         boolean isloggin = userEnitityService.adminLogin(userdetails);
//         logger.info("[INFO]: Admin loggin check -> " + isloggin);
//         assertNotEquals(isloggin, false);
//     }
//
// }
