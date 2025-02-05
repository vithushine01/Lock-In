import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/** 
 * author: Vithushine
 * date: 01/17/2025
 * Manages and organizes the tasks
 */

public class TaskManager {
    private ArrayList<Task> tasks; // List to store tasks
    private LinkedList<Task> taskQueue; // Queue to keep the tasks in order of when they are added

    public TaskManager() { // Initializes the task list and queue
        this.tasks = new ArrayList<>();
        this.taskQueue = new LinkedList<>();
    }
    
    /**
     * Adds a new task with description and deadline
     * @param description Task description
     * @param deadlineInput Task deadline as a string in the MM-dd-yyyy format
     */
    public void addTask(String description, String deadlineInput) { // Adds a new task with a description and deadline
        Date deadline = null; // Sets the deadline to null because no date is given by the user yet
        if (!deadlineInput.isEmpty()) { // Checks if user gave a deadline
           // I used ChatGPT to help me in this section of code because I was having difficulties in changing the deadline the user inputs into a date object so it suggested using a try and catch block ecause it helps with errors without the program crashing
            try { // This might cause errors but this helps the program not crash
                // Trys to convert the deadline the user inputted into a date object
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
                deadline = sdf.parse(deadlineInput); 
            } catch (Exception error) { // Helps program not to crash and inform the user what went wrong
                System.out.println("No deadline set because of error in date format.");
            }
        }

        Task task = new Task(description, deadline); // Create a new task with the description and deadline
        tasks.add(task); // Add the new task to the list of tasks
        taskQueue.offer(task); // Add the task to the queue
        System.out.println("Task added successfully!");
    }

    /**
     * Marks a task as completed
     * @param taskNumber Number of the task to mark as completed
     */
    public void markTaskAsCompleted(int taskNumber) { // Marks a test based on the number the user picks
        // Checks if the task number is valid by seeing if it is greater than 0 and less than or equal to the total number of tasks
        if (taskNumber > 0 && taskNumber <= tasks.size()) { 
              // Marks the task as completed (if the user inputs 1 for Task 1 (it accesses the task at index 0)
                tasks.get(taskNumber - 1).markAsCompleted();
                System.out.println("Task is marked as complete!");
            } else { 
                System.out.println("Invalid task number.");
            }
        }
    
    /**
     * Views all tasks in the list
     * @return The list of all the tasks in the list and if the list is empty then it prints a message to a user
     */
    public List<Task> viewTasks() { // Views all tasks in the list
        if (tasks.isEmpty()) { // Checks if there are any tasks in the list
            System.out.println("No tasks have been added yet");
        } else { 
            System.out.println("Your tasks:");
            // Loop through all the tasks and prints them with a task number starting from 1
            for (int i =0; i < tasks.size(); i++) { 
                System.out.println((i+1) + ". " + tasks.get(i)); // Prints out task and task number 
            }
        }
        return tasks; // returns the list of tasks
    }

    /**
     * Displays the next incomplete task in the queue
     * @return The next incomplete task, and if all tasks are completed then a message will be given and returns null
     */
    public Task displayNextTaskInQueue() { // Prints the next incomplete task in the queue
        // While the queue isn't empty and the first task is completed, remove it from the queue
        while (!taskQueue.isEmpty() && taskQueue.peek().isCompleted()) { 
            taskQueue.poll(); 
        }

        if (taskQueue.isEmpty()) { // Checks if the queue is empty
            System.out.println("No tasks in the queue.");
            return null;
        } else {
            // Prints the next task in the queue without removing it, only for viewing
            System.out.println("Next task in queue: " + taskQueue.peek()); 
            return taskQueue.peek();
        }
    }
    
    /**
     * Returns the amount of tasks in the list
     * @return Number of tasks
     */
    public int getTaskCount() { // Gets the total number of tasks
        return tasks.size(); // Returns the size of the task list
    }
   
}