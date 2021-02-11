package com.jwt.controller;

import com.jwt.annotation.DefaultExceptionMessage;
import com.jwt.entity.AuthenticationRequest;
import com.jwt.entity.ResponseWrapper;
import com.jwt.entity.User;
import com.jwt.exception.ServiceException;
import com.jwt.service.UserService;
import com.jwt.util.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Authenticate Controller", description = "Authenticate API")
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/authenticate")
    @DefaultExceptionMessage(defaultMessage = "Bad Credentials")
    @Operation(summary = "Login to application")
    public ResponseEntity<ResponseWrapper> doLogin(@RequestBody AuthenticationRequest authenticationRequest) {

        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();

        User foundUser = userService.readByUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authenticationToken);

        String jwtToken = jwtUtil.generateToken(foundUser);

        return ResponseEntity.ok(new ResponseWrapper("Login Succesfull!", jwtToken));

    }

    @PostMapping("/create-user")
    @DefaultExceptionMessage(defaultMessage = "Failed to create a user, please try again")
    @Operation(summary = "Create a new user")
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody User user) throws ServiceException {
        User createdUser = userService.createUser(user);

        return ResponseEntity.ok(new ResponseWrapper("User has been created successfully", createdUser));

    }
}
