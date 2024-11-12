package com.navya.Contact_Manager.dao;

import com.navya.Contact_Manager.entities.ContactGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactGroupRepository extends JpaRepository<ContactGroup,Integer> {
    // Find contact groups by name
    ContactGroup findByGroupName(String groupName);
}
