/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.service;

import com.mycompany.contactbook.pojo.UserPojo;
import java.util.List;
import com.mycompany.contactbook.exception.UserNameException;

/**
 *
 * @author rajiv
 */
public interface UserServiceInterface {

    public static final Integer LOGIN_STATUS_ACTIVE = 1;
    public static final Integer LOGIN_STATUS_BLOCKED = 2;

    public static final Integer ROLE_ADMIN = 1;
    public static final Integer ROLE_USER = 2;

    // Register new user by passing u UserPojo object
    // The function handles the user registration task and take all the user details
    public void register(UserPojo u);

    // this function takes care of user authentication by validating the username and password
    // the user login operations are handled by the function
    public UserPojo login(String loginName, String password) throws UserNameException;

    // this function returns the list of users who have completed the registration
    public List<UserPojo> getUserList();

    // this function takes care of the status of users
    public void changeLoginStatus(Integer userId, Integer loginStatus);

    // this function makes sure that the usernames are unique
    public Boolean isUsernameUnique(String username);
}
