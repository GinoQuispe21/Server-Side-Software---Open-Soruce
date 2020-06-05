package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.User;
import com.opensource.speedplanner.resource.SaveUserResource;
import com.opensource.speedplanner.resource.UserResource;
import com.opensource.speedplanner.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource) {
        return convertToResource(userService.createUser(convertToEntity(resource)));
    }

    @GetMapping ("/users/{id}")
    public UserResource getUserById(@PathVariable(name = "id") Long userId) {
        return convertToResource(userService.getUserById(userId));
    }

    @PutMapping("/users/{id}")
    public UserResource updateUser(@PathVariable(name = "id") Long userId, @Valid @RequestBody SaveUserResource resource) {
        return convertToResource(userService.updateUser(userId, convertToEntity(resource)));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("/users")
    public Page<UserResource> getAllUser(Pageable pageable) {
        List<UserResource> users = userService.getAllUser(pageable)
                .getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int usersCount = users.size();
        return new PageImpl<>(users, pageable, usersCount);
    }

    private User convertToEntity(SaveUserResource resource) { return mapper.map(resource, User.class); }

    private UserResource convertToResource(User entity) { return mapper.map(entity, UserResource.class); }
}
