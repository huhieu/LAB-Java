/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0021;

/**
 *
 * @author citih
 */
public class Student {
    String id;
    String studentName;
    String semester;
    String courseName;
    int total;   //khoi tao thuoc tinh tong so khoa hoc
    
    public Student() {
    }

    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public void print() {   //in ra ten, hoc ki, khoa hoc cua student trong selection tim kiem va sap xep
        System.out.printf("%-12s | %-1s | %-3s\n", studentName, semester, courseName);
    }
    
    public void display() {   //in ra ten, khoa hoc, tong so khoa hoc cua student trong selection bao cao
        System.out.printf("%-12s | %-6s | %-3s\n", studentName, courseName, total);
    }
    @Override
    public String toString() { 
        return "Student " + "[Id: " + id + ", Name: " + studentName + ", Semester: " + semester + ", Course: " + courseName + ']';
    }
}
