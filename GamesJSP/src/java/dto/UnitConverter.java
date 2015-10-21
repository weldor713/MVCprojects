/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.*;

/**
 *
 * @author apprentice
 */
public class UnitConverter {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        int userChoice = 0;

        System.out.print("Select Conversion Type:\n"
                + "1)Temperature.\n"
                + "2)Length.\n"
                + "3)Speed\n");
        userChoice = kb.nextByte();
        switch (userChoice) {
            case 1:
                temp();
                break;
            case 2:
                length();
                break;
            case 3:
                speed();
                break;
        }
    }

    public static void temp() {
        Scanner sc = new Scanner(System.in);
        double wha = 0, wha2 = 0, wha3 = 0;
        double cel = 0, fer = 0;       
        System.out.print("Select coversion: \n"
                + "1) F to C\n"
                + "2) C to F\n");
        wha = sc.nextInt();
        if (wha == 1){
            System.out.print("Enter F degrees: ");
            wha2 = sc.nextInt();
//            if(wha2 == 32)
//                System.out.print(wha2 + " F = 0 C\n");
//           else
            cel = (wha2 - 32)*(5.0/9.0) ;
            System.out.print(wha2 + "F = " + cel + " C\n");
        }else {
            System.out.print("Enter C degrees: ");
            wha2 = sc.nextInt();
            fer = ((9*wha2)/5.0) + 32;
            System.out.print(wha2 + " C degrees = " + fer + " F\n");
        }
        
        
    }

    public static void length() {
        Scanner sc = new Scanner(System.in);
        double in;
        double cm;
        int wha = 0;
        
        System.out.print("Select conversion: \n"
                + "1) Inchers to Centimeter\n"
                + "2) Centiments to Inches\n");
        
        wha = sc.nextInt();
        if (wha == 1){
        System.out.print("Enter inches to convert:");
        in = sc.nextDouble();
        cm = in*2.54;
        System.out.print(in + " inches = " + cm + " cm\n");
    }else{
            System.out.print("Enter centimeters to convert: ");
            cm = sc.nextDouble();
            in = cm/2.54;
            System.out.print(cm + " cm = " + in + " inches\n");
        }
    }

    public static void speed() {
        Scanner sc = new Scanner(System.in);
        int wh = 0;
        double mph;
        double kmh;
       
        
        System.out.print("Select conversion:\n"
                + "1) MPH to KMH\n"
                + "2) KMH to MPH");
        wh = sc.nextInt();
        if(wh ==1){
            System.out.print("Enter MPH:");
            mph = sc.nextDouble();
            System.out.print( mph + " mph = " + mph*1.609 + " kmh");
        }else {
            System.out.print("Enter KMH:");
            kmh = sc.nextDouble();
            System.out.print( kmh + " kmh = " + kmh/1.609);
            
        }
        
        
    }

}
