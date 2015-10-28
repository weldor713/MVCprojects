
package com.swcguild.vendmachine.model;

public class Item {
    private int itemId;
    private String name;
    private double cost;
    
    public Item(int itemId, String name, double cost){
        this.itemId = itemId;
        this.name = name;
        this.cost = cost;
    }
    
    public Item() {
        this.itemId=0;
        this.name="";
        this.cost=0.0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


}
