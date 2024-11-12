package com.navya.Contact_Manager.controller;

import com.navya.Contact_Manager.entities.ContactGroup;
import com.navya.Contact_Manager.entities.User;
import com.navya.Contact_Manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    //get all users
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //retrieve a specific user by id
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    //create new user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //update user by id
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User userDetails){
        return userService.updateUser(userId,userDetails);
    }

    //delete a user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }

    //retrieve a user's contact groups
    @GetMapping("/{userId}/contactGroups")
    public Set<ContactGroup> getUserContactGroups(@PathVariable int userId){
        return userService.getUserContactGroups(userId);
    }

    //add a contact group to a user
    @PostMapping("/{userId}/contactGroups/{groupId}")
    public User addContactGroupToUser(@PathVariable int userId, @PathVariable int groupId){
        return userService.addContactGroupToUser(userId,groupId);
    }



}
