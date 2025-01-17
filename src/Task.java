import java.text.SimpleDateFormat;
import java.util.*;

/** 
 * author: Vithushine
 * date: 01/17/2025
 * Tracks the status of the task
 */

public class Task extends BaseTask { // extends from the BaseTask class
    private boolean completed; // Tracks if the task is completed or not using true/false
    private Date deadline; // Stores the task's deadline

    /**
     * Constructor for Task
     * @param description Description of task
     * @param deadline Deadline for the task
     */
    public Task(String description, Date deadline) { // Creates task with a description and deadline
        super(description); // Calls the BaseTask constructor to set the description
        this.completed = false; // Every task that is inputted will start as not completed
        this.deadline = deadline; 
    }

    /**
     * Checks if task is completed
     * @return True if task is completed, false if not completed
     */
    public boolean isCompleted() { // Checks if the task is completed 
        return completed; // Returns whether the task is completed (true) or incomplete (false)
    }

    /**
     * Mark the task as completed
     */
    public void markAsCompleted() {
        this.completed = true; // Changes the task to completed
    }

    /**
     * Get the deadline of the task
     *
     * @return Task deadline as a Date object
     */
    public Date getDeadline() { // Gets the dealine and returns it
        return deadline;
    }

    /**
     * Gets a string representation of the task with its description, status and deadline
     * @return String with the details of the task
     */
    @Override
    public String toString() { 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Print the date in MM/dd/yyyy format
        String status = completed ? "Completed" : "Not Completed"; // If task is completed then sets it to "Completed" and if not then sets it to "Not Completed"
        String deadlineStr = (deadline != null) ? sdf.format(deadline) : "No deadline"; // Sets deadline if given, or sets it to "No deadline" when there is no deadline
        return status + " - " + getDescription() + " (Deadline: " + deadlineStr + ")"; // Returns message with the task's status, description, and deadline 
    }
}

