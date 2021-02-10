package com.jwt.controller;

import com.jwt.entity.ResponseWrapper;
import com.jwt.entity.User;
import com.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAll() {
        List<User> users = userService.getAll();

        return ResponseEntity.ok(new ResponseWrapper("Success.", users));
    }
}
