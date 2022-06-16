/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.service;

import com.mycompany.contactbook.dao.BaseDAO;
import com.mycompany.contactbook.dao.UserDAO;
import com.mycompany.contactbook.exception.UserNameException;
import com.mycompany.contactbook.objectMapper.UserObjectMapper;
import com.mycompany.contactbook.pojo.UserPojo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author rajiv
 */
@Service
public class UserServiceImplementation extends BaseDAO implements UserServiceInterface {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(UserPojo u) {
        //To change body of generated methods, choose Tools | Templates.
        userDAO.save(u);
    }

    @Override
    public UserPojo login(String loginName, String password) throws UserNameException {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName"
                + " FROM user WHERE loginName=:ln AND password=:pw";
        Map m = new HashMap();
        m.put("ln", loginName);
        m.put("pw", password);
        try {
            UserPojo u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserObjectMapper());
            if (u.getStatus().equals(UserServiceInterface.LOGIN_STATUS_BLOCKED)) {
                throw new UserNameException("Contact the admin to get your account active.");
            } else {
                return u;
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<UserPojo> getUserList() {
        //To change body of generated methods, choose Tools | Templates.
        return userDAO.findByProperty("role", UserServiceInterface.ROLE_USER);
    }

    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
        //To change body of generated methods, choose Tools | Templates.
        //throw new UnsupportedOperationException("Not supported yet."); 
        String sql = "UPDATE user SET loginStatus=:loginStatus WHERE userId=:userId";
        Map m = new HashMap();
        m.put("userId", userId);
        m.put("loginStatus", loginStatus);
        super.getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public Boolean isUsernameUnique(String username) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = "SELECT count(loginName) FROM user WHERE loginName=?";
        Integer count = getJdbcTemplate().queryForObject(sql, new String[]{username}, Integer.class);
        return count == 1;
    }

}
