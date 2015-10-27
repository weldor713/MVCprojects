/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendmachine.dao;

import com.swcguild.vendmachine.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class VendDaoDbImpl implements VendDao {
        private static final String SQL_INSERT_ITEM = 
            "insert into vendmachine (name, cost, qty) values (?, ?, ?)";
    
    private static final String SQL_DELETE_ITEM = 
            "delete from vendmachine where item_id = ?";


    private JdbcTemplate jdbcTemplate;
    
    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Item addItem(Item item) {
        jdbcTemplate.update(SQL_INSERT_ITEM, 
                item.getName(),
                item.getCost(),
        item.setItemId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return item;
    }

    @Override
    public void removeItem(int itemId) {
        jdbcTemplate.update(SQL_DELETE_ITEM, itemId);
    }
}