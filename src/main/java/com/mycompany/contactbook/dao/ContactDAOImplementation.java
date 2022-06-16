/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.dao;

import com.mycompany.contactbook.objectMapper.ContactObjectMapper;
import com.mycompany.contactbook.pojo.ContactPojo;
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
public class ContactDAOImplementation extends BaseDAO implements ContactDAO {

    @Override
    public void save(ContactPojo contact) {
        //To change body of generated methods, choose Tools | Templates.
        String sqlQuery = "INSERT INTO contact(userId, name, phone, email, address, "
                + "remark) VALUES(:userID, :name, :phoneNumber, :emailAddress, :address, :comments)";
        Map map = new HashMap();
        map.put("userID", contact.getUserID());
        map.put("name", contact.getName());
        map.put("phoneNumber", contact.getPhoneNumber());
        map.put("emailAddress", contact.getEmailAddress());
        map.put("address", contact.getAddress());
        map.put("comments", contact.getComments());
        SqlParameterSource parameterSource = new MapSqlParameterSource(map);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sqlQuery, parameterSource, keyHolder);
        contact.setContactID(keyHolder.getKey().intValue());
    }

    @Override
    public void update(ContactPojo contact) {
        //To change body of generated methods, choose Tools | Templates.
        String sqlQuery = "UPDATE contact SET name=:name, phone=:phoneNumber, "
                + "email=:emailAddress, address=:address, remark=:comments "
                + "WHERE contactId=:contactID";
        Map map = new HashMap();
        map.put("contactID", contact.getContactID());
        map.put("name", contact.getName());
        map.put("phoneNumber", contact.getPhoneNumber());
        map.put("emailAddress", contact.getEmailAddress());
        map.put("address", contact.getAddress());
        map.put("comments", contact.getComments());
        getNamedParameterJdbcTemplate().update(sqlQuery, map);
    }

    @Override
    public void delete(ContactPojo contact) {
        //To change body of generated methods, choose Tools | Templates.
        this.delete(contact.getContactID());
    }

    @Override
    public void delete(Integer contactID) {
        //To change body of generated methods, choose Tools | Templates.
        String sqlQuery = "DELETE FROM contact WHERE contactId=?";
        getJdbcTemplate().update(sqlQuery, contactID);
    }

    @Override
    public ContactPojo findById(Integer contactID) {
        //To change body of generated methods, choose Tools | Templates.
        String sqlQuery = "SELECT contactId, userId, name, phone, email, "
                + "address, remark FROM contact WHERE contactId=?";
        return getJdbcTemplate().queryForObject(sqlQuery, new ContactObjectMapper(), contactID);
    }

    @Override
    public List<ContactPojo> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        String sqlQuery = "SELECT contactId, userId, name, phone, email, "
                + "address, remark FROM contact";
        return getJdbcTemplate().query(sqlQuery, new ContactObjectMapper());
    }

    @Override
    public List<ContactPojo> findByProperty(String propertyName, Object propertyValue) {
        //To change body of generated methods, choose Tools | Templates.
        String sqlQuery = "SELECT contactId, userId, name, phone, email, "
                + "address, remark FROM contact WHERE " + propertyName + "=?";
        return getJdbcTemplate().query(sqlQuery, new ContactObjectMapper(), propertyValue);
    }

}
