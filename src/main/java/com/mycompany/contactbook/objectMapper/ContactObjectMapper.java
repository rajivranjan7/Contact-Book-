/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.objectMapper;

import com.mycompany.contactbook.pojo.ContactPojo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author rajiv
 */
public class ContactObjectMapper implements RowMapper<ContactPojo> {

    @Override
    // implementing the row mapper method to map the contact objets to the particular row from the ResultSet
    public ContactPojo mapRow(ResultSet rs, int i) throws SQLException {
        ContactPojo contact = new ContactPojo();
        contact.setContactID(rs.getInt("contactID"));
        contact.setUserID(rs.getInt("userID"));
        contact.setName(rs.getString("name"));
        contact.setEmailAddress(rs.getString("emailAddress"));
        contact.setAddress(rs.getString("address"));
        contact.setPhoneNumber(rs.getString("phoneNumber"));
        contact.setComments(rs.getString("comments"));
        return contact;
    }
}
