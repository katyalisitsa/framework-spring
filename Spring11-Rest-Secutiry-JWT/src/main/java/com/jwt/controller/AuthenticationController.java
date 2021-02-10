package com.jwt.controller;

import com.jwt.entity.AuthenticatonRequest;
import com.jwt.entity.ResponseWrapper;
import com.jwt.entity.User;
import com.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/authenticate")
    public ResponseEntity<ResponseWrapper> doLogin(@RequestBody AuthenticatonRequest authenticatonRequest) {
        String password = authenticatonRequest.getPassword();
        String username = authenticatonRequest.getUsername();

        User foundUser = userService.readByUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        authenticationManager.authenticate(authenticationToken);
    }
}
