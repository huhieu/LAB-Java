/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0021;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author citih
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> arr = new ArrayList<>();
        Manager list = new Manager();
        String input;   //khai bao chuoi input
        arr.add(new Student("1", "Nguyen Thi A", "1", "C/C++"));   //them 4 student vao danh sach
        arr.add(new Student("2", "Nguyen Thi B", "2", "Java"));
        arr.add(new Student("3", "Nguyen thi C", "3", "Java"));
        arr.add(new Student("4", "Nguyen Thi D", "4", ".Net"));
        do {
            System.out.println("");
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("        1. Create");
            System.out.println("        2. Find and Sort");            
            System.out.println("        3. Update/Delete");
            System.out.println("        4. Report");
            System.out.println("        5. Exit\n");
            System.out.println("Please give a number from 1 -> 4 to start");
            input = sc.nextLine().trim();   //ham trim() de xoa khoang trang
            //neu input khong dung(1->5) se nhap lai
            while (Validation.checkSelection(input) == false){
                System.out.println("Please enter again");
                input = sc.nextLine().trim();
            }
            switch(Integer.parseInt(input)){
                case 1: list.createStu(arr);   
                        break;
                case 2: list.findAndSort(arr);   
                        break;
                case 3: list.updateOrDelete(arr);   
                        break;
                case 4: list.reportStu(arr);   
                        break;
                case 5: System.out.println("=====Program Finished=====");   
            }
        }while (Validation.checkSelection(input) == true);  
    }
}
