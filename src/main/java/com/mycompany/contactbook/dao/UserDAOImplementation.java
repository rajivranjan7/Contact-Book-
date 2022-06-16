/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.dao;

import com.mycompany.contactbook.objectMapper.UserObjectMapper;
import com.mycompany.contactbook.pojo.UserPojo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rajiv
 */
@Repository
public class UserDAOImplementation extends BaseDAO implements UserDAO {

    @Override
    public void save(UserPojo u) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "INSERT INTO user(name, phone, email, address, loginName, "
                + "password, role, loginStatus)"
                + " VALUES(:name, :phoneNumber, :emailAddress, :address, :userName, "
                + ":password, :role, :status)";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhoneNumber());
        m.put("email", u.getEmailAddress());
        m.put("address", u.getAddress());
        m.put("loginName", u.getUserName());
        m.put("password", u.getPassword());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getStatus());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setUserID(userId);
    }

    @Override
    public void update(UserPojo u) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "UPDATE user "
                + " SET name=:name,"
                + " phone=:phone, "
                + " email=:email,"
                + " address=:address,"
                + " role=:role,"
                + " loginStatus=:loginStatus "
                + " WHERE userId=:userId";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhoneNumber());
        m.put("email", u.getEmailAddress());
        m.put("address", u.getAddress());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getStatus());
        m.put("userId", u.getUserID());
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(UserPojo u) {
        //To change body of generated methods, choose Tools | Templates.
        this.delete(u.getUserID());
    }

    @Override
    public void delete(Integer userId) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "DELETE FROM user WHERE userId=?";
        getJdbcTemplate().update(sql, userId);
    }

    @Override
    public UserPojo findById(Integer userId) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE userId=?";
        UserPojo u = getJdbcTemplate().queryForObject(sql, new UserObjectMapper(), userId);
        return u;
    }

    @Override
    public List<UserPojo> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user";
        return getJdbcTemplate().query(sql, new UserObjectMapper());
    }

    @Override
    public List<UserPojo> findByProperty(String propName, Object propValue) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE " + propName + "=?";
        return getJdbcTemplate().query(sql, new UserObjectMapper(), propValue);
    }

}
