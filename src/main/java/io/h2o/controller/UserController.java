package io.h2o.controller;

import io.h2o.entity.AppUser;
import io.h2o.entity.Student;
import io.h2o.service.AppUserService;
import io.h2o.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private AppUserService userService;

    @PostMapping("/")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return userService.saveUser(appUser);
    }
}
