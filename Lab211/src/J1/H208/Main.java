/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H208;

import java.util.Scanner;

/**
 *
 * @author citih
 */

//J1.S.H208 - 30 loc 
//nhập vào một sô nguyên dương và hoán đổi cặp chữ sô liên tiếp (nếu sô chữ số lẻ thì bỏ lại số ngoài cùng bên trái )
public class Main {
    public static Scanner SC = new Scanner(System.in);

    public static int swapDigitPairs(int n) {
    int result = 0;  //biến lưu kết quả
    int m = 1; 
    
    while(n > 0) {
        
        int d1 = n % 10;  //lưu số đầu 
        n /= 10;
        
        if(n == 0) {
            result += m * d1;
            break;
        }
        
        int d2 = n % 10; //lưu số sau
        result = result + m * 10 * d1 + m * d2; //đảo số
        n /= 10;
        m *= 100; //tăng đơn vị
    }
    
    return result;
}   
    public static boolean checkInput(String a){
         if (a == null) {  return false; } //input null 
         
        for (int i = 0; i < a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) //input character
            {
                return false;
            }
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i)>='1' && a.charAt(i)<='9') //input số
            {
                return true;
            }
        }
        
            return false;

    }

    
    
    public static void main(String[] args) {
        
       
        String input;
        int number;
        do {
            System.out.println("Enter the number : ");
            input = SC.nextLine();
            
        } while (!checkInput(input));
        number = Integer.parseInt(input);
        System.out.println(swapDigitPairs(number));
       
        
    }
    
}
