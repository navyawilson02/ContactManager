package com.navya.Contact_Manager.service;

import com.navya.Contact_Manager.dao.ContactGroupRepository;
import com.navya.Contact_Manager.entities.ContactGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactGroupService {
    private final ContactGroupRepository contactGroupRepository;

    @Autowired
    public ContactGroupService(ContactGroupRepository contactGroupRepository) {
        this.contactGroupRepository = contactGroupRepository;
    }

    public List<ContactGroup> getAllContactGroups() {
        return contactGroupRepository.findAll();
    }

    public Optional<ContactGroup> getContactGroupById(int groupId) {
        return contactGroupRepository.findById(groupId);
    }

    // Create a new contact group
    public ContactGroup createContactGroup(ContactGroup contactGroup) {
        return contactGroupRepository.save(contactGroup);
    }

    public ContactGroup updateContactGroup(int groupId, ContactGroup groupDetails) {
        return contactGroupRepository.findById(groupId).map(group -> {
            group.setGroupName(groupDetails.getGroupName());
            return contactGroupRepository.save(group);
        }).orElseThrow(() -> new RuntimeException("Contact Group not found"));
    }

    public void deleteContactGroup(int groupId) {
        contactGroupRepository.deleteById(groupId);
    }

}
