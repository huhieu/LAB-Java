/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H206;

import java.util.Scanner;

/**
 *
 * @author citih
 */

//J1.S.H206 -  40loc
//in ra hình vuông , Mỗi dòng in ra một hoán vị khác nhau của dãy số từ min đến max nhập từ bàn phím
public class Main {
    private static Scanner SC = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        int min = checkIntLimit("Enter Min: ", 0, Integer.MAX_VALUE);
        int max = checkIntLimit("Enter Max: ", min, Integer.MAX_VALUE);
        printSquare(min, max);
    }

    public static int checkIntLimit(String msg, int min, int max) {
        int rs = 0;
        do {
            try {
                System.out.print(msg);
                String input = SC.nextLine();

                rs = Integer.parseInt(input); //chuyen string thanh int

                if (rs < min || rs > max) { //kiem tra so nhap vao khong trong khoang min max
                    throw new NumberFormatException();
                }
                break;
            } catch (Exception e) {
                System.err.println("Please input data value in range " //nhap lai chuoi
                        + min + " to " + max);
            }
        } while (true);
        return rs;
    }

    public static void printSquare(int min, int max) {
        for (int i = min; i <= max; i++) { 
            for (int j = i; j <= max; j++) { //in ra tu i den max
                System.out.print(j);
            }
            for (int j = min; j < i; j++) { //in ra tu min den i 
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
  
}
