/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author citih
 */
public class Validation {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static Integer getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int num;
                num = Integer.parseInt(in.readLine());  // ép kiểu int 
                if (min <= num && num <= max) {     // nếu trong khoảng [min - max]
                    return num;                     // thì return num
                } else { // nếu không nhập lại
                    System.err.println("Number inrange[" + min + "-" + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);      // nếu không phải int thì sout 'err'
            }
        }
    }

    public static Double getDouble(String msg, String err, double min, double max) {
        while (true) {
            try {
                System.out.println(msg);                            
                double num;
                num = Double.parseDouble(in.readLine());             // ép kiểu double 
                if (min <= num && num <= max && num % 0.5 == 0) {    // nếu num nằm trong [min - max] và chia hết cho 0.5
                    return num;                                      // thì ok
                } else {
                    System.err.println("Number inrange[" + min + "-" + max + "]"); // nếu k thì báo lỗi và nhập lại
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);                    // nếu k phải double thì sout 'err'
            }
        }
    }

    public static String getString(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (str.matches(regex)) {  // check str có khớp với regex không 
                    return str;            // có thì return
                }
            } catch (IOException e) {
                System.out.println("Meet IOException");     // không thì báo lỗi
            }
            System.out.println(err);
        }
    }
    public static Boolean checkYesNo(String tmp) throws IOException {
        while (true) {
            System.out.print(tmp);
            String s = in.readLine();
            s = s.trim(); // xóa space
            if (s.compareToIgnoreCase("yes") == 0 || s.compareToIgnoreCase("y") == 0) {
                return true;
            }
            if (s.compareToIgnoreCase("no") == 0 || s.compareToIgnoreCase("n") == 0) {
                return false;
            }
            System.err.print("You must choose Yes(Y) or No(N)!\n");
        }
    }

}
