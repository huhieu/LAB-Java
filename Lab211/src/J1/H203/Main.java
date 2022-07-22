/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H203;

import java.util.Scanner;

/**
 *
 * @author citih
 */
//J1.S.H203 - 70loc
//đảo ngược từ và viết hoa kí tự đầu tiên 

public class Main {
    private static Scanner SC = new Scanner(System.in);
    

    public static String Reverse(String input) {
        String reverse = "";
        
         
         
        String[] words = input.split("\\s+");   // tach tu khi gap khoang trang 

        
        for (int i = words.length - 1; i >= 0; i--) {
            reverse += words[i] + " "; //dao nguoc tu 
        }
        

 
        reverse = reverse.substring(0, 1).toUpperCase() //in hoa ki tu dau tien
                + reverse.substring(1);
        
        
        return reverse.trim();
    }

    public static void main(String[] args) {
        do {
            System.out.print("Enter your String: ");
           
            String input = SC.nextLine().trim(); //xoa khoang trang hai dau input
            if (!input.isEmpty()) {               //kiem tra input trong
                String output = Reverse(input);
                System.out.println("String After Reverse: " + output);
                break;
            } else {
                
                System.err.println("You've enter empty string - " //chuoi trong in ra mess
                        + "Please Enter Again!");
            }
        } while (true);
    }
}
