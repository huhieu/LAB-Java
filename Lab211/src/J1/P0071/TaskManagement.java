/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.L.P0071;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author citih
 */
public class TaskManagement {
    private List<Task> listTasks = new ArrayList<>();
    
    public TaskManagement() {
        listTasks.add(new Task(1, 1, "Dev program", new Date(), 15, 16, "dev", "review"));
        listTasks.add(new Task(2, 2, "Test program", new Date(), 15, 16, "Test", "review"));
    }
    
    public void addTask() {
        int id = 1;
        if (!listTasks.isEmpty()) { //tăng giá trị id khi add
            id = listTasks.get(listTasks.size() - 1).getId() + 1;
        }
        final String NOT_IGNORE = null;
        String name = Validation.getString("Requirement Name: ", "Name invalid", "^[a-zA-Z ]+$", NOT_IGNORE);
        int taskTypeId = Validation.getInt("Task Type: ", "Task type invalid", 1, 4, NOT_IGNORE);
        Date date = Validation.getDate("Date: ", "Date invalid", "MMM-dd-yyyy", NOT_IGNORE);
        double from = Validation.getDouble("From: ", "From[8.0-17.5]", 8.0, 17.5, NOT_IGNORE);
        double to = Validation.getDouble("To: ", "To[" + from + "-17.5]", from, 17.5, NOT_IGNORE);
        String assignee = Validation.getString("Assignee: ", "Assignee invalid", "^[a-zA-Z ]+$", NOT_IGNORE);
        String reviewer = Validation.getString("Reviewer: ", "Reviewer invalid", "^[a-zA-Z ]+$", NOT_IGNORE);
        listTasks.add(new Task(id, taskTypeId, name, date, from, to, assignee, reviewer));
        System.out.println("Add task successful!");
    }
    
    public void updateTask() {
        System.out.println("------------Update Task-------------");
        final String IGNORE = "nope";
        int id = Validation.getInt("Requirement ID: ", "ID is a positive integer", 1, Integer.MAX_VALUE, null);
        int index = indexId(id);
        if (index != -1) { //kierm tra xem id có tồn tại không
            //update
            Task task = listTasks.get(index);
            String name = Validation.getString("Requirement Name: ", "Name invalid", "^[a-zA-Z ]+$", IGNORE);
            Integer taskTypeId = Validation.getInt("Task Type: ", "Task type invalid", 1, 4, IGNORE);
            Date date = Validation.getDate("Date: ", "Date invalid", "MMM-dd-yyyy", IGNORE);
            Double from = Validation.getDouble("From: ", "From[8.0-17.5]", 8.0, 17.5, IGNORE);
            Double to = null;
            if (from != null) { //update from
                task.setFrom(from);
                if (from > task.getTo()) { 
                    to = Validation.getDouble("To: ", "To[" + from + "-17.5]", from, 17.5, null); //nếu from(update) > to(chưa update) không nhập được nope
                } else {
                    to = Validation.getDouble("To: ", "To[" + from + "-17.5]", from, 17.5, IGNORE);
                }
            } else {//ko update from
                to = Validation.getDouble("To: ", "To[" + task.getFrom() + "-17.5]", task.getFrom(), 17.5, IGNORE);
            }
            if (to != null) {
                task.setTo(to);
            }
            
            String assignee = Validation.getString("Assignee: ", "Assignee invalid", "^[a-zA-Z ]+$", IGNORE);
            String reviewer = Validation.getString("Reviewer: ", "Reviewer invalid", "^[a-zA-Z ]+$", IGNORE);
            if (name != null) {
                task.setName(name);
            }
            if (taskTypeId != null) {
                task.setTaskTypeId(taskTypeId);
            }
            if (date != null) {
                task.setDate(date);
            }
            if (assignee != null) {
                task.setAssignee(assignee);
            }
            if (reviewer != null) {
                task.setReviewer(reviewer);
            }
        } else {
            System.out.println("Id not found");
        }
    }
    
    public void deleteTask() {
        System.out.println("---------Del Task------");
        int id = Validation.getInt("ID: ", "ID is a positive integer", 1, Integer.MAX_VALUE, null);
        int index = indexId(id);
        if (index != -1) { //kiểm tra id tồn tại không

            listTasks.remove(index); //xóa task
            for (int i = index; i < listTasks.size(); i++) { //giảm id khi xóa thành công
                listTasks.get(i).setId(listTasks.get(i).getId() - 1);
            }
            System.out.println("Delete success.");
        

        } else {
            System.out.println("Id not found");
        }
    }
    
    public void displayTask() { // in list
        if (listTasks.isEmpty()) {
            System.out.println("List task is empty");
        } else {
            System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                    "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            for (Task task : listTasks) {
                System.out.println(task);
            }
        }
    }
    
    private int indexId(int id) { //hàm check id tồn tại
        for (int i = 0; i < listTasks.size(); i++) {
            Task task = listTasks.get(i);
            if (task.getId() == id)  {
                return i;
            }
        }
        return -1;
    }
}
