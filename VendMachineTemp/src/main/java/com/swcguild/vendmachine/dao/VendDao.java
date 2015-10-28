package com.swcguild.vendmachine.dao;


import com.swcguild.vendmachine.model.Item;
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public interface VendDao {

    public Item addItem(Item item);
// remove the Item with the given id from the data store

    public void vendItem(int dvdId);
// update the given Dvd in the data store
    
    public void removeItem(int ItemId);
    
    public Item getItemById(int ItemId);
    
    public void addToBank (BigDecimal bd);
    
    public String makeChange (BigDecimal ch);

}
