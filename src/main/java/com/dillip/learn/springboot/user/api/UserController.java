package com.dillip.learn.springboot.user.api;

import com.dillip.learn.springboot.user.domain.User;
import com.dillip.learn.springboot.user.exceptions.UserNotFoundException;
import com.dillip.learn.springboot.user.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserDaoService userDaoService;
    @GetMapping(path="users")
    public List<User> getAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path="users/{id}")
    public User getUsers(@PathVariable int id){
        User user=userDaoService.findOne(id);
        if (user==null){
            throw new UserNotFoundException("User is not found with id:"+id);
        }
        return user;
    }

    @PostMapping(path="users")
    public ResponseEntity<User> createUsers(@Valid @RequestBody User  user){
        User savedUser=userDaoService.createUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping(path = "users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.removeUser(id);

    }


}
