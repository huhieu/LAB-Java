/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.L.P0071;

/**
 *
 * @author citih
 */
public class Main {
    public static void main(String[] args) {
        TaskManagement manager = new TaskManagement();
        while (true) {
            displayMenu();
            int option = Validation.getInt("Enter your option: ", "Option[1-5]", 1, 5, null);
            switch (option) {
                case 1:
                    manager.addTask();
                    break;
                case 2:
                    manager.updateTask();
                    break;
                case 3:
                    manager.deleteTask();
                    break;
                case 4:
                    manager.displayTask();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1. Add Task\n"
                + "2. Update Task\n"
                + "3. Delete task\n"
                + "4. Display Task\n"
                + "5. exit");
    }
}
