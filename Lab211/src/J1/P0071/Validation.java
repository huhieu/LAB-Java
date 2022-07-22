/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.L.P0071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author citih
 */
public class Validation {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static Integer getInt(String msg, String err, int min, int max, String ignore) { //check input int 
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (str != null && str.trim().equalsIgnoreCase(ignore)) { // so sánh chuỗi nhập vào  = ignore thì return
                    return null;
                }
                int num = Integer.parseInt(str);
                if (min <= num && num <= max) { //cho phép nhập giá trị trong khoàng min max
                    return num;
                } else {
                    System.out.println("Number inrange[" + min + "-" + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static Double getDouble(String msg, String err, double min, double max, String ignore) { //check input double
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (str != null && str.trim().equalsIgnoreCase(ignore)) {// so sánh chuỗi nhập vào  = ignore thì return
                    return null;
                }
                double num = Double.parseDouble(str);
                if (min <= num && num <= max && num % 0.5==0) { //cho phép nhập giá trị trong khoàng min max
                    return num;
                } else {
                    System.out.println("Number inrange[" + min + "-" + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static String getString(String msg, String err, String regex, String ignore) {//check inout string
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (str != null && str.trim().equalsIgnoreCase(ignore)) {// so sánh chuỗi nhập vào  = ignore thì return
                    return null;
                }
                if (str.matches(regex)) { //nhập giá trị matches regex
                    return str;
                }
            } catch (IOException e) {
                System.out.println("Meet IOException");
            }
            System.out.println(err);
        }
    }

    public static Date getDate(String msg, String err, String format, String ignore) { //check input date
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (str != null && str.trim().equalsIgnoreCase(ignore)) {// so sánh chuỗi nhập vào  = ignore thì return
                    return null;
                }
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                Date date = sdf.parse(str);
                return date;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }
}
