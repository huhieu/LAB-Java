/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H202;

import java.util.Scanner;

/**
 *
 * @author citih
 */

//J1.S.H202 - 30loc
//Đảo ngược chuỗi
public class Main {
    public Main() {
    }

    
    private static final Scanner SC = new Scanner(System.in);

    public static String printReverse(String input) {
        String reverseWord = "";
        
        for (int i = (input.length() - 1); i >= 0; i--) {
           
            reverseWord += input.charAt(i); //dao nguoc chuoi 
        }
        
        return reverseWord; //tra ve chuoi da dao nguoc
    }

    public static void main(String[] args) {
        System.out.print("Enter Your String: ");
        String input = SC.nextLine().trim(); //xoa khoang trang input 
        
        if (!input.isEmpty()) { // kiem tra input trong
            String output = printReverse(input);
            System.out.println("String After Reverse: " + output);
        }
    }
}
