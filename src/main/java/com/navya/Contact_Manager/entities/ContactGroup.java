package com.navya.Contact_Manager.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contact_group")
public class ContactGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    @Column(nullable = false)
    private String groupName;

    @ManyToMany(mappedBy = "contactGroups")
    private Set<Contact> contacts=new HashSet<>();

    public ContactGroup(){} //default constructor for jpa

    public ContactGroup(String groupName, Set<Contact> contacts) {
        this.groupName = groupName;
        this.contacts = contacts;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "ContactGroup{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
