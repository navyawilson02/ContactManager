package com.navya.Contact_Manager.controller;

import com.navya.Contact_Manager.entities.Contact;
import com.navya.Contact_Manager.entities.ContactGroup;
import com.navya.Contact_Manager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{contactId}")
    public Optional<Contact> getContactById(@PathVariable int contactId) {
        return contactService.getContactById(contactId);
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @PutMapping("/{contactId}")
    public Contact updateContact(@PathVariable int contactId, @RequestBody Contact contactDetails) {
        return contactService.updateContact(contactId, contactDetails);
    }

    @DeleteMapping("/{contactId}")
    public void deleteContact(@PathVariable int contactId) {
        contactService.deleteContact(contactId);
    }


    @GetMapping("/{contactId}/contactGroups")
    public Set<ContactGroup> getContactGroups(@PathVariable int contactId) {
        return contactService.getContactGroups(contactId);
    }

    @PostMapping("/{contactId}/contactGroups/{groupId}")
    public Contact addContactGroupToContact(@PathVariable int contactId, @PathVariable int groupId) {
        return contactService.addContactGroupToContact(contactId, groupId);
    }
}
