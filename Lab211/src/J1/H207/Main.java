/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H207;


 


import java.util.Scanner;


/**
 *
 * @author citih
 */
//J1.S.H207 - 30loc
//đếm và trả về sô kí tự từ nửa sau bảng chữ cái (n- z),đếm cả kí tự in hoa 

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    
    public static String checkInputString(String msg, String regex) {
        String input = null;
        do {
            System.out.print(msg);
            input = SC.nextLine().trim(); 
            if (!input.isEmpty()) {   //kiem tra input trong
                if (input.matches(regex)) {
                    break;
                } else {
                    System.err.println("Incorrect Valid Data - Enter Again");
                }
            } else {
                System.err.println("You've enter empty String - Enter Again");
            }
        } while (true);
        return input;
    }
       
    
    public static int secondHalfLetters(String s) {
		int count = 0; 
                
		for(int i = 0; i < s.length(); i++) {
			if(Character.toLowerCase(s.charAt(i)) >= 'n') {   //cho input thanh in thuong 
				count++;
			}
		}
			return count;
}
    
    public static void main(String[] args) {
        String input = checkInputString("Enter String You Want to Count: "
                , "[A-Za-z ]+"); //regex cho phep nhap a tới z hoặc A tới Z
        int countRS = secondHalfLetters(input);
        System.out.println("Value count: " + countRS);
    }
}
