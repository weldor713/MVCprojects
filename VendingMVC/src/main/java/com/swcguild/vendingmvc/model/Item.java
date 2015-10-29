/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmvc.model;

/**
 *
 * @author apprentice
 */
public class Item {
    public int itemId;
    public String name;
    public double cost;
    private int qty;
    
    public Item(int itemId, String name, double cost,int qty){
        this.itemId = itemId;
        this.name = name;
        this.cost = cost;
        this.qty = qty;
}

    public Item(){
        this.itemId = 0;
        this.name = "";
        this.cost = 0.0;
        this.qty = 0;
    }
    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
    
}

