/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

/**
 *
 * @author citih
 */
public class Validation {
    
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
     Scanner sc = new Scanner(System.in);
    
    public String checkCourseName() {   //kiem tra ten khoa hoc
        while (true){
            try {
                String s = sc.nextLine().trim();   //nhap ten khoa hoc
                //neu chuoi s gom Java/.Net/C/C++ thi tra ve chuoi s
                if (s.equalsIgnoreCase("Java") || s.equalsIgnoreCase(".Net") || s.equalsIgnoreCase("C/C++")) {   
                    return s;
                }
                throw new Exception();
            } catch (Exception e) {   //ko dung se nhap lai
                System.err.println("Course name is wrong!");
                System.out.print("Enter again: ");
            }
        }
    }
    public static boolean checkSelection(String s) {   //kiem tra lua chon
        boolean kq = s.matches("[1-5]+");   //neu lua chon thuoc(1-5) thi tiep tuc
        return kq;
    }
     public  String getString(String msg, String err, String regex) {
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
      
}
