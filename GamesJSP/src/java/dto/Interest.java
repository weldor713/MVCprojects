/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Interest {
  
    /**
     * @param args the command line arguments
     */
    public String main(double rate, double prin, double yrs) {
        Scanner kb = new Scanner(System.in);
       // double prin, rate, yrs, 
        
        double currentBalance, beginBal = 0, totTerm, yrCounter = 0;
      //  String howCompound;

//        System.out.print("Enter annual interest rate: ");
//        rate = kb.nextDouble();
//        System.out.print("Enter Principal amount: ");
//        prin = kb.nextDouble();
//        System.out.print("Enter number of years: ");
//        yrs = kb.nextDouble();
//        System.out.println("How would you like to compound interest?");
//        System.out.println("Daily (D) ; Monthly (M) ; Quarterly (Q)");
//        howCompound = kb.next();

//        String how = howCompound.toUpperCase();

//        if ("D".equals(how)) {
//
//            double dailyInt, counter = 365; //daily
//            beginBal = prin;//daily
//            totTerm = yrs * 365;//daily
//            dailyInt = rate / 365;//daily
//            currentBalance = prin;//daily
//            yrCounter = 0.0;//daily
//
//            for (int i = 1; i <= totTerm; i++) {
//                counter += 1;
//                //System.out.println("counter" + counter);
//                yrCounter += 0.002739726;
//                //System.out.println("yrCounter" + yrCounter);
//                currentBalance = currentBalance * (1 + (dailyInt / 100)); //one month int+prin
//                //System.out.println("currentBalance" + currentBalance);
//                if (counter % 365 == 0) {
//                    System.out.printf("Year :  %.2f\n", yrCounter);
//                    System.out.printf("Begining Balance: %.2f\n", beginBal);
//                    System.out.printf("Interest this year : %.2f\n", (currentBalance - beginBal));
//                    System.out.printf("Ending Balance: %.2f\n", currentBalance);
//                    beginBal = currentBalance;
//                    System.out.println();
//                }

//            }
//        } else if ("M".equals(how)) {
            String finalString = "";
            double monthInt, counter = 12; //monthly
            beginBal = prin;//monthly
            totTerm = yrs * 12;//monthly
            monthInt = rate / 12;//monthly
            currentBalance = prin;//monthly
            yrCounter = 0.0;//monthly

            for (int i = 1; i <= totTerm; i++) {
                counter += 1;
                //System.out.println("counter" + counter);
                yrCounter += 0.083333335;
                //System.out.println("yrCounter" + yrCounter);
                currentBalance = currentBalance * (1 + (monthInt / 100)); //one month int+prin
                //System.out.println("currentBalance" + currentBalance)
                if (counter % 12 == 0) {
                    
                    String s1 = String.format("%.0f",yrCounter);
                    String s2 = String.format("%.2f",beginBal);
                    String s3 = String.format("%.2f",currentBalance - beginBal);
                    String s4 = String.format("%.2f",currentBalance);
                    
                     finalString = finalString.concat("Year: " + s1 + 
                            "<br>Beginning Balance: " + s2 +
                            "<br>Interest this year: " + s3 +
                            "<br>Ending Balance: " + s4 +
                            "<br><br>");
                    
//                    System.out.printf("Year :  %.2f\n", yrCounter);
//                    System.out.printf("Begining Balance: %.2f\n", beginBal);
//                    System.out.printf("Interest this year : %.2f\n", (currentBalance - beginBal));
//                    System.out.printf("Ending Balance: %.2f\n", currentBalance);
                    beginBal = currentBalance;
                   // System.out.println();
                    
                    
                }

            }
            
            return finalString;
//        } else if ("Q".equals(how)) {
//
//            double quarterInt, counter = 4;//quarterly
//            beginBal = prin;//quarterly
//            totTerm = yrs * 4;//quarterly
//            quarterInt = rate / 4;//quarterly
//            currentBalance = prin;//quarterly
//            yrCounter = 0.0;//quarterly
//
//            for (int i = 1; i <= totTerm; i++) {
//                counter += 1;
//                //System.out.println("counter" + counter);
//                yrCounter += 0.25;
//                //System.out.println("yrCounter" + yrCounter);
//                currentBalance = currentBalance * (1 + (quarterInt / 100)); //one quarter int+prin
//                //System.out.println("currentBalance" + currentBalance)
//                if (counter % 4 == 0) {
//                    System.out.println("Year :  " + yrCounter);
//                    System.out.printf("Begining Balance: %.2f\n", beginBal);
//                    System.out.printf("Interest this year : %.2f\n", (currentBalance - beginBal));
//                    System.out.printf("Ending Balance: %.2f\n", currentBalance);
//                    beginBal = currentBalance;
//                    System.out.println();
//                }

            }
        }
    
