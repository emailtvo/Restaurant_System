package org.noobiez;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FoodItem Class
 *
 * @description Stores information about menu items.
 *
 * @author Team Noobiez
 * @version 1.0 @date 16 MARCH 12
 */
public class FoodItem {

    private double itemPrice;
    private String itemName;

    /**
     * Creates a FoodItem object with the given food name.
     *
     * @param String nameOfItem- the name of the FoodItem as found in the
     * database of food items.
     */
    public FoodItem(String nameOfItem) {
        itemName = nameOfItem;

        try {
            itemPrice = determineItemPrice(nameOfItem);
        } catch (FileNotFoundException e) {
            itemPrice = 0;
        }
    }

    /**
     * getPrice returns the price of the item.
     *
     * @return double- the price of the item.
     */
    public double getPrice() {
        return itemPrice;
    }

    /**
     * getName returns the name of the item.
     *
     * @return String - the name of the item
     */
    public String getName() {
        return itemName;
    }

    /**
     * determinItemPrice finds and returns the price of the food from the DB.
     *
     * @param nameOfItem - The name of the item
     * @return double - the price of the item; if not found, returns 0.
     * @throws FileNotFoundException
     */
    private double determineItemPrice(String nameOfItem) throws FileNotFoundException {
        //Open prices file
        File storedPricesFile = new File(System.getProperty("user.dir")
                + System.getProperty("file.separator") + "prices.dat");
        Scanner cin = new Scanner(storedPricesFile);
        String temp;
        String price = "0";

        //Read file for name of FoodItem
        while (cin.hasNextLine()) {
            temp = cin.next();

            if (temp.equals(nameOfItem))
            {                           //If found, get price value
                price = cin.next();
                cin.close();
                return Double.valueOf(price);
            }
        }

        cin.close();
        
        return Double.valueOf(price);
    }
}
