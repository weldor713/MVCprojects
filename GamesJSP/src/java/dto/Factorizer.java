/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import java.util.Scanner;

/**
 *
 * @author apprentice This is to make change for git.
 */
public class Factorizer {
    public String main(int myNum) {
        
        Scanner kb = new Scanner(System.in);
        int i,newNum,count = 0;
        
//        System.out.print("What is your number?: ");
//        myNum = kb.nextInt();
        String s = "";
        i=2;newNum = myNum;
        while (newNum>1) {
            if(newNum%i==0) {
                count++;
                //System.out.println("Factor is: " + i);
               s = s.concat(" Factor is: " + i+ "<br>");
                newNum = (newNum/i);
                //System.out.println("newNum is: " + newNum);
                i=2;
            }
            else {
            i++;
            }              
            }
        //count++;
        //System.out.println("Last Factor is: " + (i-1));
      //  System.out.println("");
        //System.out.println("Count: " + count);
     //   System.out.println("");
        if (count <=1) {
            return s +  "<br><br>Prime Number!" ;
           // System.out.println("Prime Number!");
        }
        else {
            return s + "<br><br>Not a Prime Number!" ;
            //System.out.println("Not a Prime Number...");
        }
     
    }
}
 
   
    

