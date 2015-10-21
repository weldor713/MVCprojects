/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Scanner;

/**
 *
 * @author apprentice Anthony Gallagher
 */
public class LuckeySevens {

    private int bet;
    
    /**
     * @param args the command line arguments
     */
    public String main(int bet) {
        Scanner kb = new Scanner(System.in);
        int playMoney, dice1, dice2, rolls, mostMoney, rollsMostmoney;

       // System.out.print("How much money to gamble away:");

        mostMoney = bet;
        rollsMostmoney = 0;
        rolls = 0;

        while (bet > 0) {
            rolls += 1;

            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);

            if (dice1 + dice2 == 7) {
                bet += 4;
            } else {
                bet -= 1;
            }

            if (bet > mostMoney) {
                mostMoney = bet;
                rollsMostmoney = rolls;

            }
        }

        return "you are broke after " + rolls + " rolls." 
                + "You should have quit after " + rollsMostmoney + " when you had $" + mostMoney;

    }

//    public int getDollars() {
//        return bet;
//    }
//
//    public void setDollars(int bet) {
//        this.bet = bet;
//    }
}
