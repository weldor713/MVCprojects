/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendmachine.model;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class Inventory {
    private ArrayList<Item> store;
    
    public Inventory(){
        store = new ArrayList<>();
        
    }
    public void setInventory (ArrayList al){
        store = al;
    }
    
    public ArrayList getInventory (){
        return store;
    }
    
    public Item getItem(String name){
        for(Item i : store){
            if (name.equals(i.getName())){
                return i;
            }
                
        }
        return null;
    }
    
}
