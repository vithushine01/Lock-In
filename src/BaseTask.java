public class BaseTask { 
    private String description; // Stores the description of the task
    
    /**
     * Constructor for BaseTask
     * @param description The description of the task 
     */
    public BaseTask(String description) { 
        this.description = description; 
    }

    /**
     * Get the description of the task
     * @return Task description
     */
    public String getDescription() { 
        return description; 
    }
}