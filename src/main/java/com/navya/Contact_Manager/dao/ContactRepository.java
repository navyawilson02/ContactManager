package com.navya.Contact_Manager.dao;

import com.navya.Contact_Manager.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByUserUserId(int userId); // Find contacts by the user they belong to
}
