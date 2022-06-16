/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.service;

import com.mycompany.contactbook.pojo.ContactPojo;
import java.util.List;

/**
 *
 * @author rajiv
 */
public interface ContactServiceInterface {

    public void save(ContactPojo c);

    public void update(ContactPojo c);

    public void delete(Integer contactID);

    // deleting a list of contacts
    /*
    *@param contactIds
     */
    public void delete(Integer[] contactIDs);

    public ContactPojo findById(Integer contactID);

    // return the list of all users who are registered in the system
    /**
     * @param userId
     * @return
     */
    public List<ContactPojo> findUserContact(Integer userId);

    // return the list of all users by the search criteria
    /**
     * @param userID User who is logged in
     * @param text criteria used to search - free text search criteria
     * @return
     */
    public List<ContactPojo> findUserContact(Integer userID, String text);
}
