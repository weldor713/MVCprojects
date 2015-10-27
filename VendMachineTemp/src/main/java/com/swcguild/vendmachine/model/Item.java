
package com.swcguild.vendmachine.model;

public class Item {
    private int id;
    
    private String name;
    private double cost;
    
    public Item( String name, double cost){
        this.name = name;
        this.cost = cost;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
