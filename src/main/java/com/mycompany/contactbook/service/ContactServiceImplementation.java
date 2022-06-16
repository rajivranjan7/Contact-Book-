package com.mycompany.contactbook.service;

import com.mycompany.contactbook.dao.BaseDAO;
import com.mycompany.contactbook.dao.ContactDAO;
import com.mycompany.contactbook.objectMapper.ContactObjectMapper;
import com.mycompany.contactbook.pojo.ContactPojo;
import com.mycompany.contactbook.service.ContactServiceInterface;
import com.mycompany.contactbook.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rajiv
 */
@Service
public class ContactServiceImplementation extends BaseDAO implements ContactServiceInterface {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void save(ContactPojo c) {
        //To change body of generated methods, choose Tools | Templates.
        contactDAO.save(c);
    }

    @Override
    public void update(ContactPojo c) {
        //To change body of generated methods, choose Tools | Templates.
        contactDAO.update(c);
    }

    @Override
    public void delete(Integer contactId) {
        //To change body of generated methods, choose Tools | Templates.
        contactDAO.delete(contactId);
    }

    @Override
    public void delete(Integer[] contactIds) {
        //To change body of generated methods, choose Tools | Templates.
        String ids = StringUtil.toCommaSeparatedString(contactIds);
        String sql = "DELETE FROM contact WHERE contactId IN(" + ids + ")";
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<ContactPojo> findUserContact(Integer userId) {
        //To change body of generated methods, choose Tools | Templates.
        return contactDAO.findByProperty("userId", userId);
    }

    @Override
    public List<ContactPojo> findUserContact(Integer userId, String txt) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%" + txt + "%' OR address LIKE '%" + txt + "%' OR phone LIKE '%" + txt + "%' OR email LIKE '%" + txt + "%' OR remark LIKE '%" + txt + "%')";
        return getJdbcTemplate().query(sql, new ContactObjectMapper(), userId);
    }

    @Override
    public ContactPojo findById(Integer cotactId) {
        //To change body of generated methods, choose Tools | Templates.
        return contactDAO.findById(cotactId);
    }
}
