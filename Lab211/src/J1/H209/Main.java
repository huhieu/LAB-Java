/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H209;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author citih
 */

// J1.S.H209 - 50loc
// countCoins 
public class Main {
    private static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        File file = checkFile("Enter file name: ");
        countCoins(new Scanner(file));
    }
    
    public static File checkFile(String msg) {
        String name = "";
        File file;
        do {
            System.out.print(msg);
            try {
                name = SC.nextLine();
                file = new File(name);
                if (file.exists()) { //kiem tra file có tồn tại 
                    break;
                } else {
                    System.err.println("File " + name + " does not exist. "
                            + "Please Re-Enter");
                }
            } catch (Exception e) { 
                System.err.println("Invalid File Input. Please Re-Enter");
            }
        } while (true);
        return file;
    }

    
    public static void countCoins(Scanner input) {
        double totalCents = 0; //biến lưu kết quả 
        double amount = 0;  //biến lưu số tạm thời 
        while (input.hasNext()) {
            
            String centValue = input.next();

            try {
                
                amount = Double.parseDouble(centValue); //lưu trữ giá trị số
            } catch (Exception e) {
                System.err.println("Invalid coins value!");
                return;
            }
           
            String centType = input.next(); //lưu giá trị kí tự 
            if (centType.equalsIgnoreCase("pennies")) {
                totalCents += amount * 1;
            } else if (centType.equalsIgnoreCase("nickels")) {
                totalCents += amount * 5;
            } else if (centType.equalsIgnoreCase("dimes")) {
                totalCents += amount * 10;
            } else if (centType.equalsIgnoreCase("quarters")) {
                totalCents += amount * 25;
            } else {
                System.out.println("Invalid Data!!");
                return;
            }
        }
        System.out.println("Total money: $" + String.format("%.2f", totalCents / 100));
    }
}
