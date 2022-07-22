package J1.L.P0023;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author citih
 */
public class Manager {
    Customer ct;
    
    public Manager() {
    }

    public Manager(Customer ct) {
        this.ct = ct;
    }

    public void createFruit() throws IOException { //tạo product
        System.out.println("___CREATE FRUIT___");
        while (true) {
            String fruitID = Validation.getString("Enter ID : ", "Error Input", "[a-zA-Z0-9]+");
            if (ct.findFruitByID(fruitID) != null) { //kiểm tra id tồn tại chưa
                System.err.println("Fruit existed! Enter another fruit.");
                continue;
            }
            String fruitName = Validation.getString("Enter name : ", "name invalid", "[a-zA-Z0-9]+");    
            double price = Validation.getDouble("Price: ", "Price invalid", 1, Double.MAX_VALUE);
            int quantity = Validation.getInt("Quantity: ", "Quantity invalid", 1, Integer.MAX_VALUE);
            String origin = Validation.getString("Origin: ", "Origin invalid", "^[a-zA-Z0-9 ]+$");

            
            Fruit fruit = new Fruit(fruitID, fruitName, price, quantity, origin);
            ct.addFruit(fruit);  // add
            if (!Validation.checkYesNo("Do You Want to add more fruits?(Y/N): ")) {  // kiểm tra có muốn tạo tiếp không
                System.err.println("__Creating successful__");
                System.out.println("");
                displayFruit();     // display
                System.out.println("");
                break;
            }
        }
    }

    public void updateFruit() throws IOException { //update product
        if (ct.getFruitList().isEmpty()) {  //kiểm tra rỗng
            System.err.println("Empty warehouse! Add more fruit first."); 
            System.out.println("");
            return;
        }

        System.out.println("___UPDATE FRUIT___");
        while (true) {
            String fruitID = Validation.getString("Enter ID : ", "Error Input", "[a-zA-Z0-9]+");  
            if (ct.findFruitByID(fruitID) != null) { //check id có tồn tại không, tồn tại thì in ra và update
                System.err.println("Fruit you choose: ");
                System.out.printf("|%-10s|%-15s|%-10s|%-10s|\n", "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");
                ct.findFruitByID(fruitID).print();   
                ct.update(UpdateAfruit(ct.findFruitByID(fruitID)));  
            } else { 
                System.err.println("Not found fruit with ID: " + fruitID);  // không tồn tại hỏi có tạo mới không
                if (Validation.checkYesNo("Do You Want to add more fruits?(Y/N): ")) {  
                    createFruit();
                    break;
                }
            }
            
            if (!Validation.checkYesNo("Do You Want to update another fruits?(Y/N): ")) { // check có muốn update nữa khz
                System.err.println("___Update Successfull___");
                System.out.println("");
                System.out.println("");
                break;
            }

        }
    }
// add funtion

    private Fruit UpdateAfruit(Fruit f) throws IOException {

        if (Validation.checkYesNo("Do you want to update price of fruit? (Y/N): ")) {
            double price = Validation.getDouble("New price: ", "Price Invalid", 0, Double.MAX_VALUE);
            f.setPrice(price);
        }

        if (Validation.checkYesNo("Do you want to update quantity of fruit? (Y/N): ")) {
            int quantity = Validation.getInt("New quantity: ", "Quantity invalid", 0, Integer.MAX_VALUE);
            f.setQuantity(quantity);
        }

        return f;
    }

    private void displayForOrder(ArrayList<Fruit> fruits) { //hiển thị ra các sản phẩm còn có thể order
        System.out.println("____List fruit____");
        System.out.printf("|%-10s|%-15s|%-10s|%-10s|\n", "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");

        DecimalFormat format = new DecimalFormat("0.##$");
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getQuantity() > 0) { //kiểm tra số lượng > 0
                System.out.printf("|     %-5d| %-15s| %-11s|   %-8s|\n",
                        i + 1, fruits.get(i).getFruitName(),
                        fruits.get(i).getOrigin(), format.format(fruits.get(i).getPrice()));
            }
        }
    }

    public void displayAllInforFruit(ArrayList<Fruit> x) { //hiển thị tất cả các product
        if (x.isEmpty()) { //kiểm tra rỗng
            System.err.println("Empty warehouse! Add more fruit first.");
            System.out.println("\n");
            return;
        }

        System.out.println("All Product");
        System.out.printf("|%-10s|%-15s|%-10s|%-10s|%-10s|\n", "++ ID ++", "++ Fruit Name ++",
                "++ Price ++", "++ Quantity ++", "++ Origin ++");
        for (Fruit f : x) {
            f.print();
        }
        System.out.println("");
    }

    public void shopping() throws IOException {
        // check empty
        if (ct.getFruitList().isEmpty()) { //kiểm tra rỗng
            System.err.println("Empty warehouse! Add more fruit first.");
            System.out.println("");
            System.out.println("");
            return;
        }

        ArrayList<Fruit> orderList = new ArrayList<>();
        String customer = "";
        while (true) {
            displayForOrder(ct.getFruitList()); //in ra các product còn số lượng 
            int item = Validation.getInt("Choose item: ", "Invalid Input", 1, Integer.MAX_VALUE);
            if (ct.findFruitByIndex(item) != null) { //kiểm tra item có tồn tại
                Fruit f = new Fruit(ct.findFruitByIndex(item).getFruitId(), ct.findFruitByIndex(item).getFruitName(),
                        ct.findFruitByIndex(item).getPrice(), ct.findFruitByIndex(item).getQuantity(),
                        ct.findFruitByIndex(item).getOrigin());
                System.out.println("Your select: " + f.getFruitName());
                int quantity;
                while (true) {
                    quantity = Validation.getInt("Please input quantity: ", "Input Invalid", 1, Integer.MAX_VALUE);
                    if (quantity <= f.getQuantity()) { // nếu gtri nhap vào <= quanity còn lại thì break;
                        break;
                       
                    } 
                    
                    else { 
                        System.err.println("Choose quantity you want!  <=" + f.getQuantity() + " " + f.getFruitName());
                    }
                }

                Fruit o = new Fruit(f.getFruitId(), f.getFruitName(), f.getPrice(), quantity, f.getOrigin());
                ct.setQuantity(o);
                if (orderList.isEmpty()) { //kiểm tra danh sách order rỗng
                    orderList.add(o);
//                    break;
                } else {       //tồn tại thì set thêm quantity
                    boolean isExist = false;
                    for (int i = 0; i < orderList.size(); i++) {
                        if (orderList.get(i).getFruitId().equalsIgnoreCase(o.getFruitId())) {
                            orderList.get(i).setQuantity(orderList.get(i).getQuantity() + o.getQuantity());
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) { //không tồn tại thì thêm vào 
                        orderList.add(o);
                    }
                }
//              
                if (Validation.checkYesNo("Do you want to order now? (Y/N): ")) {  //hỏi xem có muốn order luôn không
                    viewOrder(orderList); //hiển thị ra danh sách order
                    customer = Validation.getString("Input your name: ", "Input Invalid ", "[a-zA-Z0-9]+");
                    ct.order( customer,orderList); //thêm vào hashmap
                    System.out.println("");
                    break;
                }
            } else { //item không tồn tại
                System.err.println("Not found product with item: " + item);
            }
            
            if (!Validation.checkYesNo("Do you want to shopping continue? (Y/N): ")) { //nhập N thì sẽ viewOrder và nhập Y thì sẽ quay lại
                System.out.println("The products you have selected:");
                viewOrder(orderList);
                if (Validation.checkYesNo("You want to buy them? (Y/N): ")) {  //hỏi lại xem muốn mua không
                    customer = Validation.getString("Customer: ", "Input Invalid ", "[a-zA-Z0-9]+"); //nhập tên
                    ct.order( customer,orderList); //thêm vào hashmap
                    break;
                } else { //nếu không thì set lại quantity
                    for (Fruit o : orderList) {
                        ct.setQuantityIfNotOrder(o);
                    }
                    break;
                }
            }
        }
    }

    public void viewCustomerList() { //hiển thị danh sách khách mua hàng và sản phẩm đã mua
        
        if (ct.getCustomerList().isEmpty()) {
            System.err.println("There are nothing to view!");
            System.out.println("");
            System.out.println("");
            return;
        }

        double total = 0;
        DecimalFormat format = new DecimalFormat("0.##$"); // format value

        //Display
        Enumeration names = ct.getCustomerList().keys();
        ArrayList<Fruit> orderList;
        while (names.hasMoreElements()) {
            String nameStr = (String) names.nextElement(); //biến lưu tên customer
            orderList = ct.getCustomerList().get(nameStr); //lưu giá trị order
            total = 0;
            System.out.println("Customer: " + nameStr);
            System.out.println("Product    | Quantity | Price | Amount |");
            System.out.println("----------------------------------------");
            for (Fruit o : orderList) {
                System.out.printf("%-11s|    %-6d|  %-5s|   %-6s|\n", o.getFruitName(), o.getQuantity(),
                        format.format(o.getPrice()), format.format(o.getPrice() * o.getQuantity()));
                total += o.getQuantity() * o.getPrice();
            }
            System.out.println("----------------------------------------");
            System.out.printf("%-39s|\n", "Total: " + format.format(total));
            System.out.println("----------------------------------------\n");
        }
    }

    public void displayFruit() { //hiển thi danh sách sản phẩm 
        System.out.println("____List fruit____");
        System.out.printf("|%-10s|%-15s|%-10s|%-10s|\n", "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");

        DecimalFormat format = new DecimalFormat("0.##$");
        for (int i = 0; i < ct.getFruitList().size(); i++) {
            System.out.printf("|     %-5d| %-15s| %-11s|   %-8s|\n",
                    i + 1, ct.getFruitList().get(i).getFruitName(),
                    ct.getFruitList().get(i).getOrigin(), format.format(ct.getFruitList().get(i).getPrice()));
        }
    }
    

// display order
    public void viewOrder(ArrayList<Fruit> order) {
        DecimalFormat format = new DecimalFormat("0.##$");
        System.err.println("Your order: ");
        System.out.println("");
        System.out.println("Product    | Quantity | Price | Amount  |");
        System.out.println("-----------------------------------------");
        for (Fruit o : order) {
            System.out.printf("%-11s|    %-6d|  %-5s|   %-6s|\n", o.getFruitName(), o.getQuantity(),
                    format.format(o.getPrice()), format.format(o.getPrice() * o.getQuantity()));
        }

        System.out.println("");
    }
}
