package com.openapi.controller;

import com.openapi.entity.User;
import com.openapi.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name="User",description = "User API")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @Operation(summary = "Read All Users")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Successfully retrieves",
                    content = {@Content(mediaType = "application/json",schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "Something went wrong",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User now found",
                    content = @Content)

    })
    public List<User> readAll(){
        return userRepository.findAll();
    }
}
