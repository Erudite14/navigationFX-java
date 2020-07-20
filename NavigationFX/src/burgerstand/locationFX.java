/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burgerstand;

/**
 *
 * @author jostros
 */
public class locationFX
{
    private String Name;
    private double calories;
    private double price;
    boolean gas;

    public locationFX(String itemName, double calories, double price, boolean gas)
    {
        this.Name = itemName;
        this.calories = calories;
        this.price = price;
        this.gas = gas;
    }

    public String getItemName()
    {
        return Name;
    }

    public double getCalories()//x
    {
        return calories;
    }

    public double getPrice()//y
    {
        return price;
    }
    
    public boolean isGas() {
        return gas;
    }
    
    @Override
    public String toString()
    {
        return  Name + ": " + "X:" + calories + ", Y:" + price;
    }
}
