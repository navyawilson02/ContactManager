package com.navya.Contact_Manager.dao;

import com.navya.Contact_Manager.entities.Contact;
import com.navya.Contact_Manager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
