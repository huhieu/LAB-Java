/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H210;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author citih
 */

//J1.S.H210 -  40loc
//in cặp dòng theo thứ tự ngược lại ,nếu số dòng lẻ thì giữ nguyên dòng cuối 
public class Main {
     /**
     * Swap 2 line
     *
     */
    private static final Scanner SC = new Scanner(System.in);

    public static File checkFile(String msg) {
        String name = "";
        File file;
        do {
            System.out.print(msg);
            name = SC.nextLine();
            file = new File(name); 
            if (file.exists()) { //kiem tra file co ton tai khong
                break;
            } else {
                System.err.println("File " + name + " does not exist. "
                        + "Please Re-Enter");
            }
        } while (true);
        return file;
    }

    public static String flipLines(Scanner input) {
        String rs = "";

        while (input.hasNextLine()) { //kiem tra xem co dong tiep khong 
            String line1 = input.nextLine(); //lưu giá trị dòng 1 
            String line2 = ""; 
            if (input.hasNextLine()) {    //kiem tra xem co dong tiep khong   
                line2 = input.nextLine(); //gán giá trị cho line 2
            } else {
                rs += line1; 
                break;
            }

            rs += line2 + "\n" + line1 + "\n"; //đảo ngược dòng
        }
        return rs;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = checkFile("Enter file name: ");
        System.out.println(flipLines(new Scanner(file)));
    }
}
