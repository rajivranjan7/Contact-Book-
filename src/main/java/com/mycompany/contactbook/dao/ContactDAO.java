/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.dao;

import com.mycompany.contactbook.pojo.ContactPojo;
import java.util.List;

/**
 *
 * @author rajiv
 */
public interface ContactDAO {

    // method to save the contact 
    public void save(ContactPojo contact);

    // method to update the contact 
    public void update(ContactPojo contact);

    // method to delete the contact 
    public void delete(ContactPojo contact);

    // method to save the contact via contactID
    public void delete(Integer contactID);

    // method to find the contact via contactID
    public ContactPojo findById(Integer contactID);

    // returns the list of all saved contact
    public List<ContactPojo> findAll();

    // returns the list of contact searched via property (filter)
    public List<ContactPojo> findByProperty(String propertyName, Object propertyValue);
}
