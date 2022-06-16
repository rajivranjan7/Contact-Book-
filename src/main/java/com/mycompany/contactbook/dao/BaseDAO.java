/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author rajiv
 */
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
