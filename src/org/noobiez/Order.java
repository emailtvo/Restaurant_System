package org.noobiez;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    protected int tableNumber;
    protected static double totalPriceOfOrder;
    protected static ArrayList<String[]> orderList;
    protected static String[][] arrayTest;
    protected static String itemTotalDisplay;

    public Order(int tableNum) {
        tableNumber = tableNum;

        totalPriceOfOrder = 0;

        orderList = new ArrayList<String[]>();
    }

    public ArrayList<String[]> orderDetailsForTableDisplay() {
        return orderList;
    }

    public void addItem(String tableNumber, String itemName, int qty) throws IOException {
        FoodItem item = new FoodItem(itemName);
        totalPriceOfOrder += item.getPrice() * qty;
        Double itemTotal = item.getPrice() * qty;
        DecimalFormat twoDForm = new DecimalFormat("#.00");
      
        itemTotalDisplay = twoDForm.format(itemTotal);
        String[] itemDetails = {"TABLE" + tableNumber, Integer.toString(qty), item.getName(), itemTotalDisplay};
        orderList.add(itemDetails);
        writeOrderDetails(itemDetails);
    }

    private void writeOrderDetails(String[] orderDetails) throws IOException {
        File orderFile = new File(System.getProperty("user.dir") + 
                System.getProperty("file.separator") + "orders.dat"); 
        FileWriter fout = new FileWriter(orderFile, true);

        Scanner cin = new Scanner(orderFile);
        if (cin.hasNext()) {
            fout.write("\r\n"); //$NON-NLS-1$
        }
        for (int i = 0; i < orderDetails.length; ++i) {
            fout.write(orderDetails[i]);
            fout.write(" "); //$NON-NLS-1$
        }

        fout.close();
        cin.close();
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getPriceAsString() {
        return itemTotalDisplay;
    }
}