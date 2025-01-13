import java.util.Scanner;

/** 
 * author: Vithushine
 * date: 01/09/2025
 * To Do List Maker
 */

class Task {
    private String description; 
    private boolean completed; 

    public Task(String description) { 
        this.description = description; 
        this.completed = false; // every task that is inputted will start as not completed
    }

    public String getDescription() { 
        return description;
    }

    public boolean isCompleted() { 
        return completed; 
    }

    public void markAsCompleted() {
        this.completed = true; 
    }
}

class TaskApp { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Hello, Create Your To Do List Today!");
        
        
    }
}
    

    