/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author citih
 */
public class Manager {
    Scanner sc = new Scanner(System.in);
    Validation v = new Validation();
    int count = 4;   
    
    public void createStu(ArrayList<Student> arr) {
        String first = "Y";  
        String input; 
        System.out.println("=====Create Student=====");
        do {
            if (count >= 10) {                          //neu count > 10 -> tiep tuc/ko
                System.out.print("Do you want to continue?(Y/N) ");
                first = sc.nextLine().trim();           //nhap du lieu cho first
                if (first.equalsIgnoreCase("Y")) {}     //neu co thi tiep tuc nhap
                else break;                             //ngc lai se khong nhap nua
            }
            Student s = new Student();  
            
            input = v.getString("Id: ", "Id is wrong!", "[A-Za-z0-9]+");  //nhap du lieu cho id
            int exist;   //khai bao bien exist
            while ((exist = findId(input, arr)) >= 0) {   //neu exist >= 0 -> trong danh sach da co id do
                System.out.println("The code is duplicated.");
                
                input = v.getString("Id: ", "Id is wrong!", "[A-Za-z0-9]+");   //nhap lai du lieu moi cho id  
            }
            s.setId(input);   

            
            input = v.getString("Student Name: ", "Name is wrong!", "[A-Za-z ]+");   
            s.setStudentName(input);   

            
            input = v.getString("Semester: ", "Semester must be greater than 0.", "[0-9]+");    //nhap du lieu so hoc ky
            s.setSemester(input);   

            System.out.print("Course Name: ");
            input = v.checkCourseName();    
            s.setCourseName(input);   
            arr.add(s);   //them cac thong tin cua student vua duoc khoi tao vao danh sach
            System.out.println("A student has been created.");
            
            count++;
            if (count < 10) {
                System.out.print("Do you want to continue in this selection?(Y/N) ");
                first = sc.nextLine().trim();   //nhap du lieu cho first de tiep tuc/ko
            }
        } while (first.equalsIgnoreCase("Y"));
    }
    public void findAndSort(ArrayList<Student> arr) {
        String inputName;   
        String input;   
        do {
            System.out.print("Do you want to find (F) or sort (S)? ");
            input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("F")) {
                System.out.print("Enter name about some student: ");
                do {
                    inputName = sc.nextLine().trim();   
                } while (inputName.isEmpty());  
                
                int exist = findName(inputName, arr);   //tim kiem ten cua student trong danh sach
                if (exist < 0) System.out.println("This name does not exist.");  //neu ko co ten trong danh sach
                else {
                    System.out.println("======Search Student=====");
                    
                    for (Student s : arr) {
                        if (s.getStudentName().toLowerCase().contains(inputName.toLowerCase())) { //neu ten chua inputName -> in ra man hinh ten, hoc ki, ten khoa hoc cua student do
                            s.print();  
                        }
                    }
                }
            } else if (input.equalsIgnoreCase("S")) {
                if (arr.isEmpty()) System.out.println("Empty list.");   //kiểm tra danh sách rỗng
                else {
                    System.out.println("======Sort Student=====");
                    Collections.sort(arr, new Comparator<Student>() {   //sap xep cac student trong danh sach theo ten  
                        @Override
                        public int compare(Student o1, Student o2) {   //xet tung cap student
                            int kq;   //khoi tao kq
                            kq = o1.getStudentName().compareToIgnoreCase(o2.getStudentName()); //chuỗi o1 > o2 thì swap,ngược lại thì giữ nguyên
                            return kq;
                        }
                    });
                    System.out.println("The list after sorting by name");
                    for (Student s : arr) {
                        s.print();  //ham in ra man hinh ten, hoc ki, ten khoa hoc cua student do
                    }
                }
                break;
            } else break;
            System.out.print("Do you want to continue?(Y/N) ");
            input = sc.nextLine().trim();
        } while (input.equalsIgnoreCase("Y"));
    }
    public void updateOrDelete(ArrayList<Student> arr) {
        Student s = new Student(); 
        String aId;   
        String input;   
        String first;   
        do {
            System.out.print("Do you want to update (U) or delete (D)? ");
            first = sc.nextLine().trim();  
            if (first.equalsIgnoreCase("U")) {
                System.out.println("=====Update Student=====");
                System.out.print("Enter code about some student: ");
                aId = sc.nextLine().trim();   

                int exist = findId(aId, arr);   //kiểm tra id có tồn tại không
                if (exist < 0) System.out.println("This code does not exist.");   
                else {  
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).getId().equalsIgnoreCase(aId)) {   //neu id co trong danh sach
                            s.setId(aId);   //giu nguyen id cua student cu

                            
                            input = v.getString("Student Name: ", "Name is wrong!", "[A-Za-z ]+");   
                            s.setStudentName(input);   

                            
                            input = v.getString("Semester: ", "Semester must be greater than 0.", "[0-9]+");     
                            s.setSemester(input);   

                           
                            input = v.checkCourseName();   
                            s.setCourseName(input);  
                            arr.set(i, s);   //doi student cu tai i voi student vua duoc sua
                            System.out.println("The student has been updated.");
                        }
                    }
                }
            } else if (first.equalsIgnoreCase("D")) {
                System.out.print("Enter code about some student: ");
                aId = sc.nextLine().trim();   

                int exist = findId(aId, arr);  //kiểm tra id có tồn tại không
                if (exist < 0) System.out.println("This code does not exist.");  
                else {   
                    System.out.println("=====Remove Student=====");
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).getId().equalsIgnoreCase(aId)) {   //neu id co trong danh sach
                            //in ra id cua student da xoa
                            System.out.println("Student has a Id: " + arr.get(i).getId() + " will be removed.");
                            arr.remove(i);   //xoa di student
                            i--;   //danh sach se giam di 1 student
                        }
                    }

                }
            } else break;
            System.out.print("Do you want to continue?(Y/N) ");
            first = sc.nextLine().trim();  
        } while (first.equalsIgnoreCase("Y"));
    }
    public void reportStu(ArrayList<Student> arr) {
        ArrayList<Student> z = new ArrayList<>();   
        if (arr.isEmpty()) {   //kiểm tra danh sách rỗng
            System.out.println("Empty list.");
            return;
        }
        for (int i = 0; i < arr.size(); i++) {   
            z.add(arr.get(i));  
        }
        for (Student x : arr) {   
            x.total = 0;   
            String name = x.getStudentName();   
            String course = x.getCourseName();   
            for (int i = 0; i < z.size(); i++) {   
                 if (z.get(i).getStudentName().equalsIgnoreCase(name) && z.get(i).getCourseName().equalsIgnoreCase(course)) { //nếu tên và khóa học trùng thì tăng khóa học
                    x.total++;   
                    z.remove(i);  //xóa vị trí
                    i--;   //giảm size
                }
            }
            if (x.total != 0) x.display();  
        }
    }
    
    
    int findId(String aId, ArrayList<Student> arr) {   //kiểm tra id có tồn tại chưa
        for (int i = 0; i < arr.size(); i++) {
                                                    //neu chuoi aId = id trong danh sach -> tra ve index cua id tuong ung
            if (arr.get(i).getId().equalsIgnoreCase(aId)) {
                return i;
            }
        }
        return -1;   
    }
    int findName(String aName, ArrayList<Student> arr) {   //kiểm tra tên có trong danh sách chưa
        for (int i = 0; i < arr.size(); i++) {
                                                        //neu chuoi aName = ten trong danh sach se tra ve index cua ten tuong ung
            if (arr.get(i).getStudentName().toLowerCase().contains(aName.toLowerCase())) {
                return i;
            }
        }
        return -1;   
    }


}
