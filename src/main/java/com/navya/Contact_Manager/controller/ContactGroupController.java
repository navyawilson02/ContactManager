package com.navya.Contact_Manager.controller;

import com.navya.Contact_Manager.entities.ContactGroup;
import com.navya.Contact_Manager.service.ContactGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contactGroup")
public class ContactGroupController {
    private final ContactGroupService contactGroupService;

    @Autowired
    public ContactGroupController(ContactGroupService contactGroupService) {
        this.contactGroupService = contactGroupService;
    }

    @GetMapping
    public List<ContactGroup> getAllContactGroups() {
        return contactGroupService.getAllContactGroups();
    }

    @GetMapping("/{groupId}")
    public Optional<ContactGroup> getContactGroupById(@PathVariable int groupId) {
        return contactGroupService.getContactGroupById(groupId);
    }

    @PostMapping
    public ContactGroup createContactGroup(@RequestBody ContactGroup contactGroup) {
        return contactGroupService.createContactGroup(contactGroup);
    }

    @PutMapping("/{groupId}")
    public ContactGroup updateContactGroup(@PathVariable int groupId, @RequestBody ContactGroup groupDetails) {
        return contactGroupService.updateContactGroup(groupId, groupDetails);
    }

    @DeleteMapping("/{groupId}")
    public void deleteContactGroup(@PathVariable int groupId) {
        contactGroupService.deleteContactGroup(groupId);
    }
}
