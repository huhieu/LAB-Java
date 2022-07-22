/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0001;

import java.util.Scanner;

/**
 *
 * @author citih
 */

//J1.S.P0001 - 40loc
//kiem tra du lieu nhap vao cua nguoi dung, khoi tao gia tri ngau nhien cho moi phan tu trong mang, sap xep bang buble sort, hien thi ra man hinh

public class Main {

 

 
    public static int getRandomNumber(int min, int max) {
// tao ham khoi tao gia tri ngau nhien trong khoang tu (min) den (max)
        return (int) ((Math.random() * (max - min)) +min);
    }

    public static void display(int[] arr) { // in mảng

        System.out.print("[");
        for (int i = 0; i < (arr.length - 1); i++) {
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.print(arr[arr.length - 1]);
        System.out.println("]");
    }

    public static void sort(int[] arr) {
//sap xep mang theo bubble sort
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
// hoan doi arr[j+1] và arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int checkInput(String n) {
//kiem tra input 
        double a;
        try {
//kiem tra xem co phai la so o dang double hay khong
            a = Double.parseDouble(n);
        } catch (NumberFormatException nn) {
            return 2;
        }
        if (a <= 0) {

            return -1;
        } else {
            try {
//kiem tra so nhap vao co lon qua de tao mang hay khong
                int[] arr = new int[(int) a];
            } catch (OutOfMemoryError nn) {
                return 1;
            }
            return 0;
        }
    }

    public static void creatArr(int[] arr) { //tạo mảng random từ 0 đến input
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNumber(0, arr.length);
        }
    }

    public static void main(String[] args) {
        
        double n;
        String str = "0";
        Scanner s = new Scanner(System.in);
       
        do {
            System.out.println("Enter a positive decimal number:");
            str = s.nextLine();
            if (checkInput(str) == 1) {
                System.out.println("the array size you requested is too large!");
            }
            if (checkInput(str) == 2) {
                System.out.println("\""+str + "\""+ " is not a number!");
            }
            if (checkInput(str) == -1) {
                System.out.println("the number you just entered is less than 0!");
            }
        } while (checkInput(str) != 0);
        
        n = Double.parseDouble(str);
        int[] arr = new int[(int) n];
        creatArr(arr);
        
        System.out.println("Array before sort: ");
        display(arr);
       
        sort(arr);
        System.out.println("Array after sort:");
        
        display(arr);
    }
}
