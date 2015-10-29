/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmvc.dao;

import com.swcguild.vendingmvc.model.Item;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendDao {

    public Item addItem(Item item);

    public void removeItem(int itemId);
    
    public Item getItemById(int id);
    
    public List<Item> getAllItems();


    
}
