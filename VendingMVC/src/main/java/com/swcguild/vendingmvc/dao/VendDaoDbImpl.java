/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmvc.dao;

import com.swcguild.vendingmvc.model.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class VendDaoDbImpl implements VendDao {

    private static final String SQL_INSERT_ITEM
            = "insert into item (name, cost, qty) values (?, ?, ?)";

    private static final String SQL_SELECT_ITEM
            = "select * from item where item_id = ?";

    private static final String SQL_SELECT_ALL_ITEMS
            = "select * from item";

    private static final String SQL_UPDATE_ITEM
            = "update item set name = ?, cost = ?, qty = ? where item_id = ?";

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
                item.getQty());
        item.setItemId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return item;
    }

    @Override
    public Item getItemById(int itemId) {
//        try {
//            return jdbcTemplate.queryForObject(SQL_SELECT_ITEM, new ItemMapper(), itemId);
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
        return jdbcTemplate.queryForObject(SQL_SELECT_ITEM, new ItemMapper(), itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ITEMS, new ItemMapper());
    }

    @Override
    public void updateItem(Item item) {
        jdbcTemplate.update(SQL_UPDATE_ITEM,
                item.getName(),
                item.getCost(),
                item.getQty(),
                item.getItemId());

    }

    private static final class ItemMapper implements ParameterizedRowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setItemId(rs.getInt("item_id"));
            item.setName(rs.getString("name"));
            item.setCost(rs.getDouble("cost"));
            item.setQty(rs.getInt("qty"));
            return item;
        }

    }
}
