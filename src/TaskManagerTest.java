import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class TaskManagerTest {

    @Test
    void testAddTask() throws ParseException { // throws ParseExpectation was a quick fix but ParseExpectation is thrown when an error occurs
        // Arrange
        TaskManager taskManager = new TaskManager();
        String description = "Finish homework";
        String deadlineStr = "2025-01-20";

        taskManager.addTask(description, deadlineStr);
        
        // Assert
        int expectedCount = 1;
        int actualCount = taskManager.getTaskCount();
        Assertions.assertEquals(expectedCount, actualCount);

        Task task = taskManager.viewTasks().get(0);
        String expectedDescription = "Finish homework";
        String actualDescription = task.getDescription();
        Assertions.assertEquals(expectedDescription, actualDescription);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDeadline = sdf.parse(deadlineStr);
        Date actualDeadline = task.getDeadline();
        Assertions.assertEquals(expectedDeadline, actualDeadline);
        
    }

    @Test
    void testDisplayNextTaskInQueue() { 
        // Arrange
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Math", "2025-01-18");
        taskManager.addTask("Science", "2025-01-19");
        taskManager.markTaskAsCompleted(1);

        // Act
        Task nextTask = taskManager.displayNextTaskInQueue();

        // Assert
        Assertions.assertNotNull(nextTask);

        String expectedDescription = "Science";
        String actualDescription = nextTask.getDescription();
        Assertions.assertEquals(expectedDescription, actualDescription);
    }

    @Test
    void testGetTaskCount() { 
        // Arrange
        TaskManager taskManager = new TaskManager();

        // Act
        int expectedStartCount = 0;
        int actualStartCount = taskManager.getTaskCount();
        taskManager.addTask("Homework", "2025-01-18");

        int expectedUpdatedCount = 1;
        int actualUpdatedCount = taskManager.getTaskCount();

        // Assert
        Assertions.assertEquals(expectedStartCount, actualStartCount);
        Assertions.assertEquals(expectedUpdatedCount, actualUpdatedCount);
    }

        @Test
        void testMarkTaskAsCompleted() { 
            // Arrange
            TaskManager taskManager = new TaskManager();
            taskManager.addTask("Clean Window", "2025-01-18");
    
            // Act
            taskManager.markTaskAsCompleted(1);
    
            // Assert
            Task task = taskManager.viewTasks().get(0);
            Assertions.assertTrue(task.isCompleted(), "The task should be marked as completed");
        }

    @Test
    void testViewTasks() { 
        // Arrange
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Wash Clothes", "2025-01-18");
        taskManager.addTask("Fold Clothes", "");

        // Act
        List<Task> tasks = taskManager.viewTasks();

        // Assert
        int expectedTaskCount = 2;
        int actualTaskCount = tasks.size();
        Assertions.assertEquals(expectedTaskCount, actualTaskCount);

        String expectedFirstTaskDescription = "Wash Clothes";
        String actualFirstTaskDescription = tasks.get(0).getDescription();
        Assertions.assertEquals(expectedFirstTaskDescription, actualFirstTaskDescription);

        String expectedSecondTaskDescription = "Fold Clothes";
        String actualSecondTaskDescription = tasks.get(1).getDescription();
        Assertions.assertEquals(expectedSecondTaskDescription, actualSecondTaskDescription);
    }
}
