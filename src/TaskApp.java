import java.util.Scanner;

/** 
 * author: Vithushine
 * date: 01/17/2025
 * Task application where users can add tasks, mark them as completed, view them, and more!
 */

class TaskApp { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        TaskManager taskManager = new TaskManager();
        boolean running = true;

        System.out.println("Hello, Create Your To Do List Today!");
        
        while (running) {
            System.out.println("1. Add a task");
            System.out.println("2. Mark a task as completed");
            System.out.println("3. View all tasks");
            System.out.println("4. Display the next task in the queue");
            System.out.println("5. Exit");
            System.out.print("Choose what you want to do today: ");
            
            int choice = scanner.nextInt(); 
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                System.out.print("Enter your task: ");
                String description = scanner.nextLine(); 

                System.out.print("Enter the deadline in (mm/dd/yyyy) or press Enter to skip: ");
                String deadlineInput = scanner.nextLine(); 
                taskManager.addTask(description, deadlineInput);
                break;

                case 2:
                    if (taskManager.getTaskCount() == 0) { 
                        System.out.println("You have no tasks to make as completed.");
                        break;
                    }

                    System.out.println("Enter the number of the task to mark as completed: ");
                    taskManager.viewTasks(); 

                    System.out.print("Task number: ");
                    int taskNumber = scanner.nextInt(); 
                    taskManager.markTaskAsCompleted(taskNumber);
                    break;

                case 3: 
                    taskManager.viewTasks();
                    break;

                case 4: 
                    taskManager.displayNextTaskInQueue();
                    break;

                case 5: 
                    running = false;
                    System.out.println("Goodbye! See you next time!");
                    break;
                
                default:
                    System.out.println("Error. Try again.");
            }
        }
        scanner.close();
    }
}
    

    