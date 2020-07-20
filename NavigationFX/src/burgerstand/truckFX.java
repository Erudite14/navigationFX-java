/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burgerstand;
import java.util.Scanner;

/**
 *
 * @author digim
 */
public class truckFX {
    
    private String name;
    private double maxFuel;
    private double currentFuel;
    private int mpg;
    private locationFX current;

    
    
    public truckFX(String name, double maxFuel, double currentFuel, int mpg, locationFX current){
        
        this.name = name;
        this.maxFuel = maxFuel;
        this.currentFuel = currentFuel;
        this.mpg = mpg;
        this.current = current;
                        
    }
    
    
    public double getX() {
        return current.getCalories();
    }

    public double getY() {
       return current.getPrice();
    }
    
    void drive(locationFX destination){
         
        double x1, x2, y1, y2, preDis, finalDis;
             x1 = this.getX();
             y1 = this.getY();
             
              //How to get user input from the main file to the class file
              x2 = destination.getCalories();
              y2 = destination.getPrice();  
       
             preDis = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
          
             //gas used
             finalDis = preDis / 5;
             currentFuel = currentFuel - finalDis;
             
             
             if(destination.isGas()==true){// Locations can not be converted to boolean 
              ReFuel();
             System.out.println("Since this location has gas the truck has automatically refueled :E)");
             }else{
                System.out.println("This location doesn't have a gas station so refueling wasnt possible");
                System.out.println();
             }
         } 
    
    void GoElsewhere( locationFX destination){
        
        double x1, x2, y1, y2, preDis, finalDis;
             x1 = this.getX();
             y1 = this.getY();
             
             
              //How to get user input from the main file to the class file
              x2 = destination.getCalories();
              y2 = destination.getPrice();  
       
             preDis = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
          
             //gas used
             finalDis = preDis / 5;
             currentFuel = currentFuel - finalDis;
             //navigationFX.Places();
             
             if(destination.isGas()==true){// Locations can not be converted to boolean 
             ReFuel();
             System.out.println("Since this location has gas the truck has automatically refueled :E)");
             }else{
                System.out.println("This location doesn't have a gas station so refueling wasnt possible");
            }

      }
    
    
    public void ReFuel(){
        currentFuel = maxFuel;
        
    }
    
    public double getMaxFuel() {
        return maxFuel;
        
    }

    public double getCurrentFuel() {
        return currentFuel;
        
    }
}
