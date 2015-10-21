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
public class FlooringCalculator {

    /**
     * @param args the command line arguments
     */
    public String main(double width, double length, double cost) {
        Scanner kb = new Scanner(System.in);
       double area, costSqFt;
        
//        System.out.print("Enter, in whole feet, length of room: ");
//        length = kb.nextFloat();
//        
//        System.out.print("Enter in whole feet, width of room: ");
//        width = kb.nextFloat();
//        
//        System.out.print("Enter cost per square ft:");
//        cost = kb.nextFloat();
        
        area = length*width; // area of room in sq ft
        costSqFt = area*cost; // final cost of flooring in sqft
        
        //Billing:
        // $21.50 per 15 min (ch)
        // 5 sq ft per 15 min (r)
        // 15 min billing increments
        // labor amt to charge for labor only
        
      
        double labor, totCost;
        labor = (area/5)*21.5;
        totCost = labor + costSqFt;
    
        
        return "Cost of " + area + "<br>Sq ft of flooring: $" + costSqFt + "<br>Cost of labor: $" + labor + "<br>Total cost: $" + totCost;
       
        
    }
    
}
