/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0023;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author citih
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("1", "Coconut", 2, 20, "VietNam"));
        list.add(new Fruit("2", "Orange", 3, 20, "US"));
        list.add(new Fruit("3", "Apple", 4, 20, "Thailand"));
        list.add(new Fruit("4", "Grape", 6, 20, "France"));
        Hashtable<String, ArrayList<Fruit>> listView = new Hashtable<>();
        Customer ct = new Customer(list, listView);
        Manager l = new Manager(ct);

        //Process
        while (true) {
            System.out.println("==========FRUIT SHOP SYSTEM==========");
            System.out.println("================ Menu ================");
            System.out.println("1. Create Fruit");
            System.out.println("2. Update Fruit");
            System.out.println("3. View orders");
            System.out.println("4. Shopping (for buyer)");
            System.out.println("5. Exit");
            int choice = Validation.getInt("Enter choice: ", "Error Input", 1, 5);
            switch (choice) {
                case 1:
                    l.createFruit();
                    break;
                case 2:
                    l.updateFruit();
                    break;
                case 3:
                    l.viewCustomerList();
                    break;
                case 4:
                    l.shopping();
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }
}
