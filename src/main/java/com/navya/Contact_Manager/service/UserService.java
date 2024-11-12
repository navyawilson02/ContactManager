package com.navya.Contact_Manager.service;

import com.navya.Contact_Manager.dao.ContactGroupRepository;
import com.navya.Contact_Manager.dao.UserRepository;
import com.navya.Contact_Manager.entities.ContactGroup;
import com.navya.Contact_Manager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ContactGroupRepository contactGroupRepository;

    //constructor injection
    @Autowired
    public UserService(UserRepository userRepository, ContactGroupRepository contactGroupRepository){
        this.userRepository=userRepository;
        this.contactGroupRepository=contactGroupRepository;
    }

    //gives all users in database
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //gives a specific user by their id
    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    //create and save new user
    public User createUser(User user){
        return userRepository.save(user);
    }

    //to update existing details
    public User updateUser(int id, User userDetails){
        return userRepository.findById(id).map(user->{
            user.setUsername(userDetails.getUsername());
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }).orElseThrow(()->new RuntimeException("User not found"));
    }

    //retrieve a user's contact groups
    public Set<ContactGroup> getUserContactGroups(int userId) {
        return userRepository.findById(userId)
                .map(User::getContactGroups)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Add a contact group to a user
    public User addContactGroupToUser(int userId, int groupId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ContactGroup contactGroup = contactGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("ContactGroup not found"));

        user.getContactGroups().add(contactGroup); // Use getContactGroups to modify the set
        return userRepository.save(user);
    }

    // Remove a contact group from a user
//    public User removeContactGroupFromUser(int userId, int groupId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        ContactGroup contactGroup = contactGroupRepository.findById(groupId)
//                .orElseThrow(() -> new RuntimeException("ContactGroup not found"));
//
//        user.getContactGroups().remove(contactGroup); // Use getContactGroups to modify the set
//        return userRepository.save(user);
//    }

    //to delete the user with that id
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
