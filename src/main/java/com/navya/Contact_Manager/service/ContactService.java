package com.navya.Contact_Manager.service;

import com.navya.Contact_Manager.dao.ContactGroupRepository;
import com.navya.Contact_Manager.dao.ContactRepository;
import com.navya.Contact_Manager.entities.Contact;
import com.navya.Contact_Manager.entities.ContactGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactGroupRepository contactGroupRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, ContactGroupRepository contactGroupRepository) {
        this.contactRepository = contactRepository;
        this.contactGroupRepository = contactGroupRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(int contactId) {
        return contactRepository.findById(contactId);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(int contactId, Contact contactDetails) {
        return contactRepository.findById(contactId).map(contact -> {
            contact.setFirstname(contactDetails.getFirstname());
            contact.setLastname(contactDetails.getLastname());
            contact.setPhone_number(contactDetails.getPhone_number());
            contact.setEmail(contactDetails.getEmail());
            contact.setUser(contactDetails.getUser());
            return contactRepository.save(contact);
        }).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    public void deleteContact(int contactId) {
        contactRepository.deleteById(contactId);
    }

    public Set<ContactGroup> getContactGroups(int contactId) {
        return contactRepository.findById(contactId)
                .map(Contact::getContactGroups)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    public Contact addContactGroupToContact(int contactId, int groupId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        ContactGroup contactGroup = contactGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Contact Group not found"));

        contact.getContactGroups().add(contactGroup);
        return contactRepository.save(contact);
    }

}
