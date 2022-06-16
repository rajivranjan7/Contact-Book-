/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.dao;

import com.mycompany.contactbook.pojo.UserPojo;
import java.util.List;

/**
 *
 * @author rajiv
 */
public interface UserDAO {

    // method to save the user
    public void save(UserPojo u);

    // method to update the user
    public void update(UserPojo u);

    // method to delete the user
    public void delete(UserPojo u);

    // method to delete the user based on userId
    public void delete(Integer userId);

    // method to save the user based on usreId
    public UserPojo findById(Integer userId);

    // method to return the user list
    public List<UserPojo> findAll();

    // method to return the user list based on property
    public List<UserPojo> findByProperty(String propName, Object propValue);
}
