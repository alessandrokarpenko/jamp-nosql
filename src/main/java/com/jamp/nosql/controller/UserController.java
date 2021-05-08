package com.jamp.nosql.controller;

import com.jamp.nosql.models.Sport;
import com.jamp.nosql.models.User;
import com.jamp.nosql.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User service", description = "API for interaction with users")
public class UserController {

    @Autowired()
    private UserService userService;

    @PostMapping()
    @Operation(summary = "Create new user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find user by id")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return userService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Find user by email")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/sport")
    @Operation(summary = "Add sport to user")
    public ResponseEntity<User> addSport(@PathVariable String id, @RequestBody Sport sport) {
        return userService.addSport(id, sport).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sportName/{sportName}")
    @Operation(summary = "Find users by sport name")
    public ResponseEntity<Collection<User>> findUsersBySportName(@PathVariable String sportName) {
        return ResponseEntity.ok(userService.findUsersBySportName(sportName));
    }

}













