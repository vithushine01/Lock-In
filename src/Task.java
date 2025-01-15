import java.text.SimpleDateFormat;
import java.util.*;
/** 
 * author: Vithushine
 * date: 01/09/2025
 * To Do List Maker
 */

class BaseTask { 
    private String description; 
    public BaseTask(String description) { 
        this.description = description;
    }

    public String getDescription() { 
        return description; 
    }
}
class Task extends BaseTask {
    private boolean completed; 
    private Date deadline;

    public Task(String description, Date deadline) { 
        super(description); // calls the BaseTask constructor
        this.completed = false; // every task that is inputted will start as not completed
        this.deadline = deadline;
    }

    public boolean isCompleted() { 
        return completed; 
    }

    public void markAsCompleted() {
        this.completed = true; 
    }

    public Date getDeadline() { 
        return deadline;
    }

    @Override
    public String toString() { 
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy"); 
        String status = completed ? "Completed" : "Not Completed";
        String deadlineStr = (deadline != null) ? sdf.format(deadline) : "No deadline";
        return status + " - " + getDescription() + " (Deadline: " + deadlineStr + ")";
    }
}

