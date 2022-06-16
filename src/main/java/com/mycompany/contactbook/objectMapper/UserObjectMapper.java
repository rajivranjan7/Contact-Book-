/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.objectMapper;

import com.mycompany.contactbook.pojo.UserPojo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author rajiv
 */
public class UserObjectMapper implements RowMapper<UserPojo> {

    @Override
    // implementing the row mapper method to map the user objets to the particular row from the ResultSet
    public UserPojo mapRow(ResultSet rs, int i) throws SQLException {
        UserPojo user = new UserPojo();
        user.setUserID(rs.getInt("userID"));
        user.setName(rs.getString("name"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setEmailAddress(rs.getString("emailAddress"));
        user.setAddress(rs.getString("address"));
        user.setUserName(rs.getString("userName"));
        user.setRole(rs.getInt("role"));
        user.setStatus(rs.getInt("status"));
        return user;
    }
}
