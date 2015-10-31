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
public class Change {

    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    public String makeChange(double startingMoney) {
        double a = startingMoney;
        double q, d, n, p;
        q = a / 25;
        quarters = (int) q;

        if (q > 0) {
            a = a % 25;
        }

        d = a / 10;
        dimes = (int) d;

        if (d > 0) {
            a = a % 10;
        }

        n = a / 5;
        nickels = (int) n;

        if (n > 0) {
            a = a % 5;
        }

        p = a;
        pennies = (int) p;

        String str = "You received " + quarters + " quarters, " + dimes + " dimes, "
                + nickels + " nickels, " + pennies + " pennies as change.";
        
        return str;

    }
}
